package com.raldes.movie_compose.presentation.moviedetails

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun TopBar() {

    TopAppBar(title = {
        Text(
            text = "Title top bar",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        }
    },
        actions = {
            IconButton(
                onClick = { /*TODO*/ },
                content = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                }
            )
        }

    )
}