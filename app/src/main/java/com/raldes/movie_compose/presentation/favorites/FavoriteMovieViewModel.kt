package com.raldes.movie_compose.presentation.favorites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raldes.domain.model.Movie
import com.raldes.domain.usecase.GetAllFavoriteMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val getFavoriteMovieUseCase: GetAllFavoriteMoviesUseCase): ViewModel() {

    var movies: List<Movie>? by mutableStateOf(null)
    var loadingState: Boolean by mutableStateOf(false)
    var errorMsg: String by mutableStateOf("")

    init {
        getAllFavoriteMovies()
    }

    private fun getAllFavoriteMovies() {
        viewModelScope.launch {
            loadingState = true
            getFavoriteMovieUseCase().catch {
                loadingState = false
                Timber.e(it)
                errorMsg = "Something went wrong"
            }.collect {
                loadingState = false
                movies = it
            }
        }
    }
}