package com.raldes.movie_compose.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raldes.domain.model.Movie
import com.raldes.movie_compose.presentation.ui.Poster
import com.raldes.movie_compose.presentation.ui.PosterDetails

@Composable
fun HomeItem(
    movie: Movie,
    modifier: Modifier = Modifier) {

    Row(modifier = modifier
        .clickable { }
        .background(MaterialTheme.colors.background)
        .padding(horizontal = 10.dp, vertical = 8.dp)
        .fillMaxWidth()) {

        Poster(posterUrl =  movie.posterUrl,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(2 / 3f))

        PosterDetails(movie = movie,
            modifier = Modifier.weight(3f)
                .padding(horizontal = 10.dp))
    }
}