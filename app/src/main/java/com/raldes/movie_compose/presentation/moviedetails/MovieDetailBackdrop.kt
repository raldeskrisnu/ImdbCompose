package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun MovieDetailBackdrop(imgUrl: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(16f / 9),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberGlidePainter(request = imgUrl, fadeIn = true)


        Image(painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize())

        when (painter.loadState) {
            is ImageLoadState.Loading-> {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    strokeWidth = 2.dp
                )
            }
            is ImageLoadState.Error -> Box(modifier = Modifier.fillMaxWidth())
            else -> {}
        }
    }
}