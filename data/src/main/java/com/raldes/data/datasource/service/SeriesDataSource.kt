package com.raldes.data.datasource.service

import com.raldes.data.network.SeriesService
import com.raldes.data.response.mappers.asSeries
import com.raldes.data.response.mappers.asSeriesDetails
import com.raldes.domain.model.SeriesDetails
import com.raldes.domain.model.SeriesMapperResponse
import javax.inject.Inject

class SeriesDataSource @Inject constructor(private val seriesService: SeriesService) {

    suspend fun getTrendingSeries(page: Int): SeriesMapperResponse {
        return seriesService.getTrendingTvSeries(page).asSeries()
    }

    suspend fun getTopRatedSeries(page: Int): SeriesMapperResponse {
        return seriesService.getTopRatedTvSeries(page).asSeries()
    }

    suspend fun getTvDetailsSeries(tvId: Long): SeriesDetails {
        return seriesService.getTvSeriesDetails(tvId).asSeriesDetails()
    }
}