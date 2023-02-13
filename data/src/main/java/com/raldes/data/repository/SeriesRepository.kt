package com.raldes.data.repository

import com.raldes.data.datasource.service.SeriesDataSource
import com.raldes.domain.implement.SeriesImpl
import com.raldes.domain.model.Series
import com.raldes.domain.model.SeriesDetails
import com.raldes.domain.model.SeriesMapperResponse
import javax.inject.Inject

class SeriesRepository @Inject constructor(private val seriesDataSource: SeriesDataSource): SeriesImpl {

    override suspend fun getTrendingSeries(page: Int): SeriesMapperResponse =
        seriesDataSource.getTrendingSeries(page)

    override suspend fun getTopRatedSeries(page: Int): SeriesMapperResponse  =
        seriesDataSource.getTopRatedSeries(page)

    override suspend fun getDetailSeriesByTvId(tvId: Long): SeriesDetails =
        seriesDataSource.getTvDetailsSeries(tvId)

}