package com.raldes.movie_compose.presentation.moviedetails

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import timber.log.Timber
import java.lang.reflect.Modifier

@Composable
@Preview
fun MovieDetailScreen() {

    Scaffold(topBar = {
        val title = "Details Movie"
        TopBar()
    }, content = { _ ->
        Text(text = "Movie detail screen")
    }
    )
}