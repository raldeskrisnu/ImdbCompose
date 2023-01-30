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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
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

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(posterUrl)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.wrapContentSize().clip(MaterialTheme.shapes.medium)
            )
        }
    }

}