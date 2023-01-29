package com.raldes.domain.model

import com.raldes.domain.Constant

data class Series(
    val id: Long,
    val title: String?,
    val overview: String?,
    val firstAirDate: String?,
    val poster: String?,
    val backdrop: String?,
    val voteAverage: Double?,
    val isFavorite: Boolean?
) {
    val posterUrl = if(poster !=null) Constant.POSTER_URL + poster else ""
    val backdropUrl = if(backdrop !=null) Constant.BACKDROP_URL + backdrop else ""
}