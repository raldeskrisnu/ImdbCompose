package com.raldes.movie_compose.presentation.favorites

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raldes.domain.model.Movie
import com.raldes.domain.usecase.GetAllFavoriteMoviesUseCase
import com.raldes.domain.usecase.GetFavoriteMoviesByIdUseCase
import com.raldes.domain.usecase.SaveFavoriteMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMovieViewModel @Inject constructor(
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase,
    private val getFavoriteMoviesByIdUseCase: GetFavoriteMoviesByIdUseCase,
    private val getFavoriteMovieUseCase: GetAllFavoriteMoviesUseCase): ViewModel() {


}