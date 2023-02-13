package com.raldes.movie_compose.presentation.series

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.raldes.domain.model.Series
import com.raldes.domain.usecase.GetSeriesTrendingUseCase
import com.raldes.domain.usecase.GetTopRatedSeriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(private val seriesTrendingUseCase: GetSeriesTrendingUseCase,
                                          private val topRatedSeriesUseCase: GetTopRatedSeriesUseCase): ViewModel() {

    private val _trendingTvSeries = mutableStateOf<Flow<PagingData<Series>>>(emptyFlow())
    val trendingTvSeries: State<Flow<PagingData<Series>>> = _trendingTvSeries

    private val _topRatedTvSeries = mutableStateOf<Flow<PagingData<Series>>>(emptyFlow())
    val topRatedTvSeries: State<Flow<PagingData<Series>>> = _topRatedTvSeries

    init {
        getTrendingSeries()
        getTopRatedSeries()
    }

    fun getTrendingSeries() {
        viewModelScope.launch {
            _trendingTvSeries.value = Pager(
                config = PagingConfig(enablePlaceholders = false, pageSize = 10),
                pagingSourceFactory = {
                    SeriesPagingDataSource(seriesTrendingUseCase)
                }
            ).flow.cachedIn(viewModelScope)
        }
    }

    fun getTopRatedSeries() {
        viewModelScope.launch {
            _topRatedTvSeries.value = Pager(
                config = PagingConfig(enablePlaceholders = true, pageSize = 10),
                pagingSourceFactory = {
                    SeriesTopRatedPagingDataSource(topRatedSeriesUseCase)
                }
            ).flow.cachedIn(viewModelScope)
        }
    }
}