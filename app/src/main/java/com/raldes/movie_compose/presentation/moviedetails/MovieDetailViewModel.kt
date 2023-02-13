package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.SeriesDetails
import com.raldes.domain.usecase.*
import com.raldes.movie_compose.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    private val getMovieDetailByIdUseCase: GetMovieDetailByIdUseCase,
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase,
    private val deleteMovieByIdUseCase: DeleteMovieByIdUseCase,
    private val getFavoriteMoviesByIdUseCase: GetFavoriteMoviesByIdUseCase,
    private val getSeriesDetailUseCase: GetSeriesDetailUseCase
): ViewModel() {

    val movId: String? = stateHandle["movieId"]
    var movieDetails: MovieDetails? by mutableStateOf(null)
    var seriesDetails: SeriesDetails? by mutableStateOf(null)
    var isLoading: Boolean by mutableStateOf(false)
    var errMsg: Int? by mutableStateOf(null)

    var isFavoriteLoading: Boolean by mutableStateOf(false)
    var isFavorite: Boolean? by mutableStateOf(null)


    init {
        getMovieDetailsById(movId?.toLong())
        getMoviesFavoriteById(movId?.toLong())
    }

    private fun getMovieDetailsById(movieId: Long?, isSeries: Boolean = false) {
        viewModelScope.launch {
            isLoading = true
            try {
                if(isSeries) {
                    seriesDetails = movieId?.let { getSeriesDetailUseCase(it) }
                } else {
                    movieDetails = movieId?.let { getMovieDetailByIdUseCase(it) }
                }

            } catch (e: Exception) {
                Timber.e(e)
                errMsg = R.string.error_message
            }
            isLoading = false
        }
    }

    private fun getMoviesFavoriteById(movieId: Long?) {
        viewModelScope.launch {
            isFavoriteLoading = true
            if (movieId != null) {
                getFavoriteMoviesByIdUseCase(movieId)
                    .catch {
                        isFavoriteLoading = false
                    }.collect {
                        isFavorite = it?.isFavorite
                        isFavoriteLoading = false
                    }
            }
        }
    }

    fun saveFavoriteMovie() {
        viewModelScope.launch {
            isFavoriteLoading = true
            if(isFavorite == true) {
                movId?.toLong()?.let { deleteMovieByIdUseCase(it) }
                isFavorite = false
            } else {
                movieDetails?.movies?.let { saveFavoriteMovieUseCase(it) }
                isFavorite = true
            }
            isFavoriteLoading = false
        }
    }
}