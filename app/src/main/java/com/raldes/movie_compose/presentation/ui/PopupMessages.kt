package com.raldes.movie_compose.presentation.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PopupMessages (@StringRes resId: Int) {
    
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(32.dp),
        Alignment.Center) {

        Text(text = stringResource(id = resId),
            textAlign = TextAlign.Center
        )
    }
}