package com.raldes.movie_compose.presentation.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DialogMessage (modifier: Modifier = Modifier, message: String, onRetry: () -> Unit) {

    Column(modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = message,
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.error)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onRetry) {
            Text(text = "Try again")
        }
    }
}