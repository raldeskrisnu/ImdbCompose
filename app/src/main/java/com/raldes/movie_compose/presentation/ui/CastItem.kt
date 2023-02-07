package com.raldes.movie_compose.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.raldes.movie_compose.R
import com.raldes.movie_compose.ui.theme.lightGray

@Composable
fun CastItem(castName: String, imageUrl: String, size: Dp) {
    var isExpanded by remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().size(size).padding(8.dp).clip(CircleShape)
        )

        Text(
            text = castName,
            color = lightGray,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 11.sp,
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            overflow = if (isExpanded) TextOverflow.Visible else TextOverflow.Ellipsis,
            modifier = Modifier.padding(all = 4.dp)
        )
    }
}