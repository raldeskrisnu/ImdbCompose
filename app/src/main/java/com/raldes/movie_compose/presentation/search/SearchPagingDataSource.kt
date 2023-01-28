package com.raldes.movie_compose.presentation.search

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.raldes.domain.model.Movie
import com.raldes.domain.usecase.SearchMovieUseCase

class SearchPagingDataSource(private val query: String, private val searchMovieUseCase: SearchMovieUseCase): PagingSource<Int, Movie>() {

    private val STARTING_PAGE_INDEX = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = searchMovieUseCase(query, page)

            LoadResult.Page(
                data = response.listMovie,
                prevKey = if(page == STARTING_PAGE_INDEX) null else -1,
                nextKey = if(page == response.totalPages || response.totalPages == 0) null else page + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}