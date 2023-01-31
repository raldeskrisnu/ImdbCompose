package com.raldes.data.datasource.local

import com.raldes.domain.model.Movie

fun FavoriteTableDb.asMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    poster = posterPath,
    backdrop = backdropPath,
    popularity = null,
    voteAverage = voteAverage,
    voteAccount = voteCount,
    isFavorite = isFavorite)

fun List<FavoriteTableDb>.asMovies() = this.map { it.asMovie() }