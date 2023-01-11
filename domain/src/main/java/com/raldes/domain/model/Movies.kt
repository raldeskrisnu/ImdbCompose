package com.raldes.domain.model

data class Movies (
    val listMovie: List<Movie>,
    val currentPage: Int,
    val totalPages: Int)