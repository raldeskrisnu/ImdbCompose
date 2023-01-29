package com.raldes.movie_compose.presentation.series

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalMovies
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SeriesPoster(modifier: Modifier) {
    
    Box(modifier
            .wrapContentSize()
            .clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center) {

       Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {

           Image(imageVector = Icons.Default.LocalMovies,
               contentDescription = "Series Image",
            Modifier.padding(vertical = 5.dp))

           Text(text = "Series Title")
       }
    }
}