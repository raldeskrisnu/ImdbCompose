package com.raldes.data.repository

import com.raldes.data.datasource.SeriesDataSource
import com.raldes.domain.implement.SeriesImpl
import com.raldes.domain.model.SeriesMapperResponse
import javax.inject.Inject

class SeriesRepository @Inject constructor(private val seriesDataSource: SeriesDataSource): SeriesImpl {

    override suspend fun getTrendingSeries(page: Int): SeriesMapperResponse =
        seriesDataSource.getTrendingSeries(page)

}