package com.raldes.movie_compose.presentation.search

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
fun SearchMovieScreen() {

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Search screen") })
    }, content = { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Text(text = "Search screen")
        }
    })

}