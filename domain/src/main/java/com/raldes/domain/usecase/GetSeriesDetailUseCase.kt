package com.raldes.domain.usecase

import com.raldes.domain.implement.SeriesImpl
import com.raldes.domain.model.Series
import com.raldes.domain.model.SeriesDetails
import com.raldes.domain.model.SeriesMapperResponse
import javax.inject.Inject

class GetSeriesDetailUseCase @Inject constructor(private val seriesImpl: SeriesImpl) {

    suspend operator fun invoke(tvId: Long): SeriesDetails {
        return seriesImpl.getDetailSeriesByTvId(tvId)
    }
}