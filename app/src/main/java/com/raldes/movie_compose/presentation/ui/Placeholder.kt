package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.material.icons.filled.MovieFilter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.raldes.movie_compose.presentation.ui.Colors.white10

@Composable
@Preview
fun Placeholder(modifier: Modifier = Modifier) {

    Box(modifier = modifier.background(
        shape = MaterialTheme.shapes.medium,
        color = white10),
        contentAlignment = Alignment.Center) {
        
        Icon(imageVector = Icons.Default.LocalMovies,
            contentDescription = null,
            tint = MaterialTheme.colors.primary)
    }
}