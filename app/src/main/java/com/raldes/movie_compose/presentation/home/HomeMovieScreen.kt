package com.raldes.movie_compose.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.FlowPreview

@FlowPreview
@Composable
fun HomeMovieScreen(viewModel: HomeViewModel = hiltViewModel(),
                    gotoDetailScreen: (movieId: Long) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Home") },
            actions = {
                IconButton(onClick = {
                    //on click
                } ) {
                    Icon(Icons.Default.Search, "")
                }
            }
        )
    }, content = { paddingValues ->
        val lazyViewModel = viewModel.getPagedMovies().collectAsLazyPagingItems()

        LazyColumn(contentPadding = paddingValues) {
            items(
                items = lazyViewModel,
                key = { item -> item.id }
            ) { item ->
                if (item != null) {
                    HomeItem(movie = item, onMovieClick = { gotoDetailScreen(it) })
                }
            }
        }
    })
}