package com.raldes.domain.model

import com.raldes.domain.Constant

data class Movie(
    val id: Long,
    val title: String?,
    val overview: String?,
    val releaseDate: String?,
    val poster: String?,
    val backdrop: String?,
    val popularity: Double?,
    val voteAverage: Double?,
    val voteAccount: Int?,
    val isFavorite: Boolean?
) {
    val posterUrl = if(poster !=null) Constant.POSTER_URL + poster else ""
    val backdropUrl = if(backdrop !=null) Constant.BACKDROP_URL + backdrop else ""
}