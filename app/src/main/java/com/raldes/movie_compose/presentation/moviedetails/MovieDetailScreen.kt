package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raldes.movie_compose.R
import com.raldes.movie_compose.presentation.ui.CastSection
import com.raldes.movie_compose.presentation.ui.Loading
import com.raldes.movie_compose.presentation.ui.PopupMessages
import com.raldes.movie_compose.presentation.ui.moviesFontFamily

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit) {

    val scrollState = rememberScrollState()

    Scaffold(topBar = {
        val title = if(movieDetailViewModel.movieDetails?.movies?.title !=null) movieDetailViewModel.movieDetails?.movies?.title else "Details Movies"

       TopBar(title = title ?: "",
            upPressed = onBackPressed,
            isFavorite = movieDetailViewModel.isFavorite == true,
            isFavoriteLoading = movieDetailViewModel.isFavoriteLoading,
            onFavoriteClicked = { movieDetailViewModel.saveFavoriteMovie() },
            isSeries = movieDetailViewModel.isSeries.toBoolean())
    }, content = { padding ->
        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(padding)
        ) {
            if(movieDetailViewModel.isLoading) {
                Loading()
            } else {
                movieDetailViewModel.errMsg.let {
                    if(it!=null) {
                        PopupMessages(it)
                        return@Scaffold
                    }
                }

                if(movieDetailViewModel.isSeries.toBoolean()) {
                    movieDetailViewModel.seriesDetails?.let { details ->

                        //banner section
                        MovieDetailBackdrop(details.series.backdropUrl)

                        //poster section
                        MovieInfoPosterRow(details.series.posterUrl, details.genres, details.series.title)
                        MovieRating(details.series.firstAirDate, null, details.series.voteAverage)

                        //header section
                        details.series.overview?.let {
                            MovieHeader(stringResource(id = R.string.sinopsys))
                            Overview(it)
                        }
                    }
                } else {
                    movieDetailViewModel.movieDetails?.let { details ->

                        //banner section
                        MovieDetailBackdrop(details.movies.backdropUrl)

                        //poster section
                        MovieInfoPosterRow(details.movies.posterUrl, details.genres, details.movies.title)
                        MovieRating(details.movies.releaseDate, details.movies.voteAccount, details.movies.voteAverage)

                        //header section
                        details.movies.overview?.let {
                            MovieHeader(stringResource(id = R.string.sinopsys))
                            Overview(it)
                        }

                        //cast section
                        CastSection(details.cast)
                    }
                }


            }


        }
    }

    )
}