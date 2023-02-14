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
import com.raldes.domain.model.Genre
import com.raldes.domain.model.MovieDetails
import com.raldes.movie_compose.presentation.ui.Poster

@Composable
fun MovieInfoPosterRow(
    posterUrl: String?,
    listGenres: List<Genre>,
    title: String?
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Poster(
            posterUrl = posterUrl,
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2 / 3f)
        )

        MovieInfo(listGenres = listGenres,
                    modifier = Modifier
                        .weight(3f)
                        .padding(start = 16.dp),
                    title = title)
    }
}

@Composable
private fun MovieInfo(listGenres: List<Genre>, modifier: Modifier = Modifier, title: String?) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(modifier = Modifier.fillMaxWidth(),
            text = title ?: "",
            style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(32.dp))

        FlowRow(
            mainAxisSpacing = 4.dp,
            crossAxisSpacing = 8.dp,
        ) {
            listGenres.forEach {
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