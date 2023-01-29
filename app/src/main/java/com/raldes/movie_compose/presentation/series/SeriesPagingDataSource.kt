package com.raldes.movie_compose.presentation.series

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raldes.domain.model.Series
import com.raldes.domain.usecase.GetSeriesTrendingUseCase

class SeriesPagingDataSource(private val seriesTrendingUseCase: GetSeriesTrendingUseCase): PagingSource<Int,Series>() {

    private val INDEX = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Series> {
        val page = params.key ?: INDEX

        return try {
            val response = seriesTrendingUseCase(page)

            LoadResult.Page(
                data = response.listSeries,
                prevKey = if(page == INDEX) null else page -1,
                nextKey = if(page == response.totalPages || response.totalPages == 0) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Series>): Int? {
        return state.anchorPosition
    }
}