package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.glide.rememberGlidePainter
import com.raldes.movie_compose.R

@Composable
@Preview
fun Poster(modifier: Modifier = Modifier) {

    Box(modifier = modifier
        .wrapContentSize()
        .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center) {
       val painter = rememberGlidePainter(request = "posterUrl")
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier= modifier
                .wrapContentSize()
                .clip(MaterialTheme.shapes.medium))
    }

}