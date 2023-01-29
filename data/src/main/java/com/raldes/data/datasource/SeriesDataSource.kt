package com.raldes.data.datasource

import com.raldes.data.network.SeriesService
import com.raldes.data.response.mappers.asSeries
import com.raldes.domain.model.SeriesMapperResponse
import javax.inject.Inject

class SeriesDataSource @Inject constructor(private val seriesService: SeriesService) {

    suspend fun getTrendingSeries(page: Int): SeriesMapperResponse {
        return seriesService.getTrendingTvSeries(page).asSeries()
    }
}