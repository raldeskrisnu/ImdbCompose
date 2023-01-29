package com.raldes.data.response.mappers

import com.raldes.data.response.MovieDetailResponse
import com.raldes.data.response.MovieResults
import com.raldes.data.response.MovieResponse
import com.raldes.domain.model.*

fun MovieResponse.asMovies() = MoviesMapperResponse(
    results.map { it.asMovie() },
    currentPage = page,
    totalPages = totalPages
)

fun MovieResults.asMovie() = Movie(
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

fun MovieDetailResponse.asMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        releaseDate = releaseDate,
        poster = posterPath,
        backdrop = backdropPath,
        popularity = popularity,
        voteAverage = voteAverage,
        voteAccount = voteCount,
        isFavorite = null,
    )
}

fun MovieDetailResponse.asCast(): List<Cast?> {
    return credits.cast?.map {
        it.id?.let { it1 ->
            Cast(
                id = it1,
                movieId = id,
                actorName = it.name,
                imagePath = it.profilePath,
            )
        }
    }?.toList() ?: emptyList()
}

fun MovieDetailResponse.asGenres(): List<Genre> {
    return genres?.map {
        Genre(
            id = it.id,
            movieId = id,
            name = it.name,
        )
    }?.toList() ?: emptyList()
}

fun MovieDetailResponse.asMovieDetail(): MovieDetails {
    @Suppress("UNCHECKED_CAST")
    return MovieDetails(
        movies = asMovie(),
        genres = asGenres(),
        cast = asCast() as List<Cast>,
        trailers = asVideos() as List<MovieTrailers>
    )
}

fun MovieDetailResponse.asVideos(): List<MovieTrailers?> {
    return videos.videos?.map {
        it.id?.let { it1 ->
            MovieTrailers(
                id = it1,
                movieId = id,
                key = it.key,
                name = it.name,
            )
        }
    }?.toList() ?: emptyList()
}