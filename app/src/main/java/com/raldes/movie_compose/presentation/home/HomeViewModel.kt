package com.raldes.movie_compose.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.raldes.domain.model.Movie
import com.raldes.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val popularMoviesUseCase: GetPopularMoviesUseCase): ViewModel() {

    private val _trendingTvSeries = mutableStateOf<Flow<PagingData<Movie>>>(emptyFlow())
    val trendingTvSeries: State<Flow<PagingData<Movie>>> = _trendingTvSeries

    init {
        getPagedMovies()
    }

    fun getPagedMovies() {
        viewModelScope.launch {
            _trendingTvSeries.value = Pager(
                config = PagingConfig(enablePlaceholders = false, pageSize = 10),
                pagingSourceFactory = {
                    HomePagingDataSource(popularMoviesUseCase)
                }
            ).flow.cachedIn(viewModelScope)
        }
    }
}