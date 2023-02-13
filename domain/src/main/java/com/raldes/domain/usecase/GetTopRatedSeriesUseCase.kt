package com.raldes.domain.usecase

import com.raldes.domain.implement.SeriesImpl
import com.raldes.domain.model.SeriesMapperResponse
import javax.inject.Inject

class GetTopRatedSeriesUseCase @Inject constructor(private val seriesImpl: SeriesImpl) {

    suspend operator fun invoke(page: Int): SeriesMapperResponse {
        return seriesImpl.getTopRatedSeries(page)
    }
}