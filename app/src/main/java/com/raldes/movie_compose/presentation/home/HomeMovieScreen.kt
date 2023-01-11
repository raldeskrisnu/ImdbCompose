package com.raldes.movie_compose.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.FlowPreview

@FlowPreview
@Composable
@Preview
fun HomeMovieScreen(viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Home") })
    }, content = { paddingValues ->
        val lazyViewModel = viewModel.getPagedMovies().collectAsLazyPagingItems()

        LazyColumn(contentPadding = paddingValues) {
            items(
                items = lazyViewModel,
                key = { item -> item.id }
            ) { item ->

            }
        }
    })
}