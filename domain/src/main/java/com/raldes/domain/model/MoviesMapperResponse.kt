package com.raldes.domain.model

data class MoviesMapperResponse (
    val listMovie: List<Movie>,
    val currentPage: Int,
    val totalPages: Int)