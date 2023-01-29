package com.raldes.movie_compose.presentation.series

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SeriesItem() {

    Row {
        SeriesPoster(Modifier.weight(1f)
            .aspectRatio(2 / 3f))
    }
}