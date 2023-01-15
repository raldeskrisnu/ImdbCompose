package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.google.accompanist.imageloading.ImageLoadState
import com.raldes.domain.model.Movie
import com.raldes.movie_compose.R

@Composable
fun Poster(
    posterUrl: String?,
    modifier: Modifier = Modifier) {

    Box(modifier = modifier
        .wrapContentSize()
        .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center) {

        if(posterUrl == null) {
            Placeholder(modifier.matchParentSize())
        } else {
            val painter = rememberGlidePainter(request = posterUrl)
            Image(painter = painter,
                contentDescription = null,
                modifier= modifier
                    .wrapContentSize()
                    .clip(MaterialTheme.shapes.medium))

            when(painter.loadState) {
                is ImageLoadState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp)
                    )
                }
                is ImageLoadState.Error -> {
                    Placeholder(modifier)
                }
                else -> {}
            }
        }
    }

}