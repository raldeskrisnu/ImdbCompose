package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun Loading() {
    Box(modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
        content = {
        CircularProgressIndicator()
    })
}