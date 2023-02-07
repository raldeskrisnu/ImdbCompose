package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raldes.domain.model.Cast

@Composable
fun CastSection(listCast: List<Cast>) {

    Column {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Cast",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontFamily = moviesFontFamily,
                    fontSize = 16.sp,
                    letterSpacing = 0.20.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp))
        }

        LazyRow{
            items(listCast) { cast ->
                cast.actorName?.let { cast.imageUrl?.let {
                        it1 -> CastItem(castName = it, imageUrl = it1, size = 80.dp) } }
            }

        }
    }
}