package com.raldes.movie_compose.presentation.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raldes.domain.model.Movie
import com.raldes.movie_compose.R
import com.raldes.movie_compose.presentation.home.HomeItem
import com.raldes.movie_compose.presentation.ui.DialogMessage
import com.raldes.movie_compose.presentation.ui.Loading
import com.raldes.movie_compose.presentation.ui.PagingLoadState
import com.raldes.movie_compose.presentation.ui.PopupMessages
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
                       PagingLoadState(modifier = Modifier.fillParentMaxSize())
                    }
                }

                is LoadState.Error -> {
                    val state = lazyPagingItems.loadState.refresh as LoadState.Error
                    item {
                        DialogMessage(modifier = Modifier.fillParentMaxSize(),
                            message = state.error.message ?: stringResource(id = R.string.error_message),
                        onRetry = {
                            retry()
                        })
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
                        Loading()
                    }
                }

                is LoadState.Error -> {
                    val state = lazyPagingItems.loadState.append as LoadState.Error
                    item {
                        DialogMessage(modifier = Modifier.fillParentMaxSize(),
                            message = state.error.message ?: stringResource(id = R.string.error_message),
                            onRetry = {
                                retry()
                            })
                    }
                }

                LoadState.NotLoading(endOfPaginationReached = true) -> {
                    if (lazyPagingItems.itemCount == 0) {
                        item {
                            //empty state
                        }
                    }
                }
                else -> {}
            }
        }
    }
}