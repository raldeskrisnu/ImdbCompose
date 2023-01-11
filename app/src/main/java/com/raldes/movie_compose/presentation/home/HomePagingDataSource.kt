package com.raldes.movie_compose.presentation.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raldes.domain.model.Movie
import com.raldes.domain.usecase.GetPopularMoviesUseCase

class HomePagingDataSource (private val popularUseCase: GetPopularMoviesUseCase): PagingSource<Int, Movie>() {

    private val INDEX = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: INDEX

        return try {
            val response = popularUseCase(page)

            LoadResult.Page(
                data = response.listMovie,
                prevKey = if(page == INDEX) null else page -1,
                nextKey = if(page == response.totalPages || response.totalPages == 0) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}