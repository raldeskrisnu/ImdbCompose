package com.raldes.movie_compose.presentation.series

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SeriesItem(modifier: Modifier, bannerUrl: String) {
    Card(modifier = modifier.padding(4.dp)) {
        Image(imageVector = Icons.Default.Movie,
            contentDescription = "Movie banner",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop)
    }
}