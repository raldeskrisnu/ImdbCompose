package com.raldes.data.response.mappers

import com.raldes.data.response.SeriesResponse
import com.raldes.data.response.SeriesResults
import com.raldes.domain.model.Series
import com.raldes.domain.model.SeriesMapperResponse

fun SeriesResponse.asSeries() = SeriesMapperResponse(
    results.map { it.asSeries() },
    page = page,
    totalPages = totalPages
)

fun SeriesResults.asSeries() = Series(
    id = seriesId,
    title = name,
    overview = overview,
    firstAirDate = firstAirDate,
    poster = poster,
    backdrop = backdropPath,
    voteAverage = voteAverage,
    isFavorite = false
)