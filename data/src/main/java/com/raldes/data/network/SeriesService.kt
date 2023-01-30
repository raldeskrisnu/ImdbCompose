package com.raldes.data.network

import com.raldes.data.response.MovieResponse
import com.raldes.data.response.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesService {

    @GET("trending/tv/day")
    suspend fun getTrendingTvSeries(@Query("page") page: Int): SeriesResponse
}