package com.raldes.movie_compose.presentation.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.raldes.movie_compose.ui.theme.lightBlue
import com.raldes.movie_compose.utils.isNotNullOrEmpty

@Composable
fun SearchMovieTextField(value: TextFieldValue,
                         onValueChange: (TextFieldValue) -> Unit) {

    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        }, trailingIcon = {
            AnimatedVisibility(visible = value.text.isNotNullOrEmpty(),
            enter = fadeIn(),
            exit = fadeOut()) {
                IconButton(onClick = { onValueChange(TextFieldValue()) }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear icons")
                }
            }
        }, placeholder = {
            Text(text = "Search Something")
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            focusedIndicatorColor = lightBlue,
            placeholderColor = lightBlue,
            cursorColor = lightBlue
        )
    )
}