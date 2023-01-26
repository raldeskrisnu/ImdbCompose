package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raldes.domain.model.Genre
import com.raldes.domain.model.Movie
import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.Movies
import com.raldes.domain.usecase.GetMovieDetailByIdUseCase
import com.raldes.movie_compose.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
    private val getMovieDetailByIdUseCase: GetMovieDetailByIdUseCase): ViewModel() {

    val id: String? = stateHandle["movieId"]
    var movieDetails: MovieDetails? by mutableStateOf(null)
    var isLoading: Boolean by mutableStateOf(false)
    var errMsg: Int? by mutableStateOf(null)

    init {
        getMovieDetailsById(movieId = id?.toLong())
    }

    private fun getMovieDetailsById(movieId: Long?) {
        viewModelScope.launch {
            isLoading = true
            try {
                movieDetails = movieId?.let { getMovieDetailByIdUseCase(it) }
            } catch (e: Exception) {
                Timber.e(e)
                errMsg = R.string.error_message
            }
            isLoading = false
        }
    }

}