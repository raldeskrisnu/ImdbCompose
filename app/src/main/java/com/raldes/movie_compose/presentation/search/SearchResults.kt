package com.raldes.movie_compose.presentation.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raldes.domain.model.Movie
import com.raldes.movie_compose.presentation.home.HomeItem
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchMovieResults(searchTerm: String,
                       resuls: Flow<PagingData<Movie>>,
                       onItemClick: (movieId: Long) -> Unit) {

    val lazyPagingItems = resuls.collectAsLazyPagingItems()

    LazyColumn {
        items(
            items = lazyPagingItems,
            key = { item -> item.id }
        ) { item ->
            if (item != null) {
                HomeItem(
                    movie = item,
                    onMovieClick = onItemClick
                )
            }
        }

        lazyPagingItems.apply {
            when (loadState.refresh) {
                is LoadState.Loading -> {
                    item {
                       // PagingLoadingView(modifier = Modifier.fillParentMaxSize())
                    }
                }

                is LoadState.Error -> {
                    val state = lazyPagingItems.loadState.refresh as LoadState.Error
                    item {

                    }
                }

                LoadState.NotLoading(endOfPaginationReached = true) -> {
                    if (lazyPagingItems.itemCount == 0) {
                        item {

                        }
                    }
                }
                else -> {}
            }

            when (loadState.append) {
                is LoadState.Loading -> {
                    item {
                        //PagingLoadingItem()
                    }
                }

                is LoadState.Error -> {
                    val state = lazyPagingItems.loadState.append as LoadState.Error
                    item {

                    }
                }

                LoadState.NotLoading(endOfPaginationReached = true) -> {
                    if (lazyPagingItems.itemCount == 0) {
                        item {
                            
                        }
                    }
                }
                else -> {}
            }
        }
    }
}