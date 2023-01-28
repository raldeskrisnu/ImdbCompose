package com.raldes.movie_compose.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.raldes.domain.model.Movie
import com.raldes.domain.usecase.SearchMovieUseCase
import com.raldes.movie_compose.utils.isNotNullOrEmpty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(private val searchMoviesUseCase: SearchMovieUseCase): ViewModel() {

    val searchQuery = MutableStateFlow("")
    var searchResults: Flow<PagingData<Movie>>? by mutableStateOf(null)
    private var currentJob: Job? = null

    init {
        viewModelScope.launch {
            searchQuery.debounce(300)
                .collectLatest { searchQuery->
                    currentJob?.cancel()
                    currentJob = launch {
                        searchResults = if (searchQuery.isNotNullOrEmpty()) doSearchMovies(searchQuery.trim()) else null
                    }
                }
        }
    }

    private fun doSearchMovies(query: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 10),
            pagingSourceFactory = {
                SearchPagingDataSource(query, searchMoviesUseCase)
            }
        ).flow.cachedIn(viewModelScope)
    }

    fun updateQuery(query: String) {
        searchQuery.value = query
    }
}