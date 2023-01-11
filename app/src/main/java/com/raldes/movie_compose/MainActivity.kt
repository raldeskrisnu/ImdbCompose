package com.raldes.movie_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.raldes.movie_compose.presentation.MainScreen
import com.raldes.movie_compose.ui.theme.MoviecomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviecomposeTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }
}