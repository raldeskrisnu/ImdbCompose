package com.raldes.data.response.mappers

import com.raldes.data.response.MovieDetailResponse
import com.raldes.data.response.SeriesResponse
import com.raldes.data.response.SeriesResults
import com.raldes.data.response.TvSeriesDetails
import com.raldes.domain.model.*

fun SeriesResponse.asSeries() = SeriesMapperResponse(
    results.map { it.asSeries() },
    page = page,
    totalPages = totalPages
)

fun SeriesResults.asSeries():Series {
    return Series(id = seriesId,
        title = name,
        overview = overview,
        firstAirDate = firstAirDate,
        poster = poster,
        backdrop = backdropPath,
        voteAverage = voteAverage,
        isFavorite = null)
}

fun TvSeriesDetails.asGenres(): List<Genre> {
    return genres.map {
        Genre(
            id = it.id,
            movieId = id,
            name = it.name,
        )
    }.toList() ?: emptyList()
}

fun TvSeriesDetails.asSeries(): Series {
    return Series(
        id = id,
        title = name,
        overview = overview,
        firstAirDate = firstAirDate,
        poster = posterPath,
        backdrop = backdropPath,
        voteAverage = voteAverage,
        isFavorite = null)
}


fun TvSeriesDetails.asSeriesDetails(): SeriesDetails {
    @Suppress("UNCHECKED_CAST")
    return SeriesDetails(
        series = asSeries(),
        genres = asGenres()
    )
}