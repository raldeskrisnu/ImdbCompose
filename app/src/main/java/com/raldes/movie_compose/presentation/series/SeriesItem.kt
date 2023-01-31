package com.raldes.movie_compose.presentation.series

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.raldes.movie_compose.R
import com.raldes.movie_compose.presentation.ui.moviesFontFamily
import com.raldes.movie_compose.ui.theme.lightGray

@Composable
fun SeriesItem(modifier: Modifier, bannerUrl: String, movieName: String) {
    Card(modifier = modifier.padding(4.dp)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(bannerUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Movie banner",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            Modifier
                .fillMaxSize()
                .alpha(0.6f)) {
            Box(
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(lightGray),
                content = {
                    Text(text = movieName,
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.caption,
                    fontSize = 16.sp)
                }
            )
        }
    }
}