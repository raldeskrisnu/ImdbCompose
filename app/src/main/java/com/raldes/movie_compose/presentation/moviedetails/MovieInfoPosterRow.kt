package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.raldes.domain.model.MovieDetails
import com.raldes.movie_compose.presentation.ui.Poster

@Composable
fun MovieInfoPosterRow(
    movieDetails: MovieDetails
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
//        Image(imageVector = Icons.Default.Movie,
//            contentDescription = null,
//            modifier = Modifier.weight(2f).aspectRatio(2 / 3f))
        Poster(
            posterUrl = movieDetails.movies.posterUrl,
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2 / 3f)
        )

        MovieInfo(movieDetails = movieDetails,
                    modifier = Modifier
                        .weight(3f)
                        .padding(start = 16.dp))
    }
}

@Composable
private fun MovieInfo(movieDetails: MovieDetails, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(modifier = Modifier.fillMaxWidth(),
            text = movieDetails.movies.title ?: "",
            style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(32.dp))

        FlowRow(
            mainAxisSpacing = 4.dp,
            crossAxisSpacing = 8.dp,
        ) {
            movieDetails.genres.forEach {
                if (it.name != null) GenreCompose(genreName = it.name!!)
            }
        }
    }


}

@Composable
private fun GenreCompose(genreName: String) {
    Surface(
        elevation = 4.dp,
        shape = RoundedCornerShape(70),
        color = MaterialTheme.colors.primary
    ) {
        Text(
            text = genreName,
            style = MaterialTheme.typography.body2,
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}