package com.raldes.movie_compose.utils

fun CharSequence?.isNotNullOrBlank(): Boolean {
    return !this.isNullOrBlank()
}

fun CharSequence?.isNotNullOrEmpty(): Boolean {
    return !this.isNullOrEmpty()
}
