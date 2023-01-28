package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    title:String,
    isFavorite:Boolean,
    isFavoriteLoading:Boolean,
    onFavoriteClicked: () -> Unit,
    upPressed: () -> Unit) {

    TopAppBar(contentColor = Color.White,
        title = {
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }, navigationIcon = {
        IconButton(onClick = upPressed ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        }
    },
        actions = {
            if(isFavoriteLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    color = MaterialTheme.colors.primary,
                    strokeWidth = 2.dp
                )
            }
            IconButton(
                onClick = { onFavoriteClicked },
                content = {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            )
        }
    )
}