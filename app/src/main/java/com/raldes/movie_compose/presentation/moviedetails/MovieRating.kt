package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.filled.Stars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raldes.domain.model.Movie
import com.raldes.movie_compose.utils.isNotNullOrEmpty

@Composable
fun MovieRating(movie: Movie) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {

            if(movie.releaseDate.isNotNullOrEmpty()) {
                Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                movie.releaseDate?.let {
                    Text(text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }

            movie.voteAccount?.let {
                Icon(imageVector = Icons.Default.People, contentDescription = null)
                Text(text = "${it} votes",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 4.dp))
                Spacer(modifier = Modifier.weight(1f))
            }

            movie.voteAverage?.let {
                Icon(imageVector = Icons.Default.StarRate, contentDescription = null)
                Text(text = "${it} Averages",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 5.dp))
                Spacer(modifier = Modifier.weight(1f))
            }
            

        }
    }
}