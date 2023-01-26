package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PagingLoadState(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center,
        content = {
            CircularProgressIndicator()
        })
}