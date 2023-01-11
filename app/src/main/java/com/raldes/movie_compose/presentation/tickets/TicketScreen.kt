package com.raldes.movie_compose.presentation.tickets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TicketScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Ticket screen") })
    }, content = { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Text(text = "Ticket screen")
        }
    })
}