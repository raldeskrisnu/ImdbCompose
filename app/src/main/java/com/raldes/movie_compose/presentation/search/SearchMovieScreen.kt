package com.raldes.movie_compose.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchMovieScreen(
    onBackPressed:() -> Unit,
    viewModel: SearchMovieViewModel = hiltViewModel()) {

    var query by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Scaffold(topBar = {
        TopAppBar(contentColor = Color.White,
            title = {
                Text(text = "Search")
            }, navigationIcon = {
                IconButton(onClick = onBackPressed ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                }
            }
        )
    }, content = { paddingValues ->
        Column(Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally) {
            SearchMovieTextField(value = query, onValueChange = {
                query = it
                viewModel.updateQuery(it.text)
            })
        }
    })

}