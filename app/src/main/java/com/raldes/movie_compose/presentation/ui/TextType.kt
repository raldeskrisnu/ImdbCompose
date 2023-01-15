package com.raldes.movie_compose.presentation.ui

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raldes.movie_compose.R

private val light = Font(R.font.montserrat_light)
private val regular = Font(R.font.montserrat_regular)
private val bold = Font(R.font.montserrat_bold)
private val medium = Font(R.font.montserrat_medium)

val moviesFontFamily = FontFamily(fonts = listOf(light, regular, medium, bold))

val typography = androidx.compose.material.Typography(
    h1 = TextStyle(
        fontFamily = moviesFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        letterSpacing = 0.15.sp
    )
)