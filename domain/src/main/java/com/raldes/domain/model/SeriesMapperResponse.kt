package com.raldes.domain.model

data class SeriesMapperResponse(
    val listSeries: List<Series>,
    val page: Int,
    val totalPages: Int)