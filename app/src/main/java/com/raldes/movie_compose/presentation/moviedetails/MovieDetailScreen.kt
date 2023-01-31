package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.raldes.movie_compose.R
import com.raldes.movie_compose.presentation.ui.PopupMessages

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {

    val scrollState = rememberScrollState()

    Scaffold(topBar = {
        val title = if(viewModel.movieDetails?.movies?.title !=null) viewModel.movieDetails?.movies?.title else "Details Movies"

       TopBar(title = title!!,
            upPressed = onBackPressed,
            isFavorite = true,
            isFavoriteLoading = true,
            onFavoriteClicked = {

            })
    }, content = { padding ->
        Column(
            Modifier
                .verticalScroll(scrollState)
                .padding(padding)
        ) {
            if(viewModel.isLoading) {

            } else {
                viewModel.errMsg.let {
                    if(it!=null) {
                        PopupMessages(it)
                        return@Scaffold
                    }
                }

                viewModel.movieDetails?.let { details ->
                    //banner section
                    MovieDetailBackdrop(details.movies.backdropUrl)

                    //poster section
                    MovieInfoPosterRow(details)
                    MovieRating(details.movies)

                    //header section
                    details.movies.overview?.let {
                        MovieHeader(stringResource(id = R.string.sinopsys))
                        Overview(it)
                    }


                }
            }
        }
    }

    )
}