package com.raldes.movie_compose.presentation.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raldes.movie_compose.presentation.ui.PagingLoadState

@Composable
fun HomeMovieScreen(viewModel: HomeViewModel = hiltViewModel(),
                    gotoDetailScreen: (movieId: Long) -> Unit,
                    gotoSearchScreen: () -> Unit) {

   val lazyViewModel = viewModel.popularMovies.value.collectAsLazyPagingItems()

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Top Movie") },
            actions = {
                IconButton(onClick = {
                    gotoSearchScreen()
                } ) {
                    Icon(Icons.Default.Search, "")
                }
            }
        )
    }, content = { paddingValues ->

        LazyColumn(contentPadding = paddingValues) {
            items(
                items = lazyViewModel,
                key = {
                    item -> item.id
                }
            ) { item ->
                if (item != null) {
                    HomeItem(movie = item,
                        onMovieClick = { gotoDetailScreen(it) })
                }
            }

            lazyViewModel.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item {
                            PagingLoadState(modifier = Modifier.fillParentMaxSize())
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                                    .wrapContentWidth(Alignment.CenterHorizontally)
                            )
                        }
                    }

                    loadState.refresh is LoadState.Error -> {

                    }

                    loadState.append is LoadState.Error -> {

                    }
                }
            }
        }
    })
}