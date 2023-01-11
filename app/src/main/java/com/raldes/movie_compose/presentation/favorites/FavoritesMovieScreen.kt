package com.raldes.movie_compose.presentation.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun FavoritesMovieScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Favorites screen") })
    }, content = { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Text(text = "Favorites screen")
        }
    })
}