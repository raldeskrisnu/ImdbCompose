package com.raldes.movie_compose.presentation.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raldes.movie_compose.presentation.home.HomeItem
import com.raldes.movie_compose.presentation.ui.Loading

@Composable
fun FavoritesMovieScreen(viewModel: FavoriteMovieViewModel = hiltViewModel(),
                         gotoMovieDetails: (movieId: Long) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Favorites screen") })
    }) { paddingValues ->
        if(viewModel.loadingState) {
            Loading()
        } else if (viewModel.movies == null) {
            //no favorite items
        } else {
            LazyColumn(contentPadding = paddingValues) {
                val items = viewModel.movies ?: emptyList()
                itemsIndexed(items) { index, item ->
                    val bottomPadding = if (index == items.size - 1) 64 else 0
                    HomeItem(movie = item, onMovieClick = gotoMovieDetails,
                        modifier = Modifier.padding(bottom = bottomPadding.dp))
                }
            }
        }
    }
}