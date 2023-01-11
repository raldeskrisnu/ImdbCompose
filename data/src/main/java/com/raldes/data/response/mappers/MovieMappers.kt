package com.raldes.data.response.mappers

import com.raldes.data.response.MovieNetwork
import com.raldes.data.response.MovieResponse
import com.raldes.domain.model.Movie
import com.raldes.domain.model.Movies

fun MovieResponse.asMovies() = Movies(
    results.map { it.asMovie() },
    currentPage = page,
    totalPages = totalPages
)


fun MovieNetwork.asMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    poster = poster,
    backdrop = backdrop,
    popularity = popularity,
    voteAverage = voteAverage,
    voteAccount = voteCount,
    isFavorite = null)