package com.raldes.domain.implement

import com.raldes.domain.model.SeriesDetails
import com.raldes.domain.model.SeriesMapperResponse

interface SeriesImpl {
    suspend fun getTrendingSeries(page: Int): SeriesMapperResponse

    suspend fun getTopRatedSeries(page: Int): SeriesMapperResponse

    suspend fun getDetailSeriesByTvId(tvId: Long): SeriesDetails
}