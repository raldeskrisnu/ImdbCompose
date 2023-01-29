package com.raldes.domain.implement

import com.raldes.domain.model.SeriesMapperResponse

interface SeriesImpl {
    suspend fun getTrendingSeries(page: Int): SeriesMapperResponse
}