package com.raldes.data.network

import com.raldes.data.response.MovieResponse
import com.raldes.data.response.SeriesResponse
import com.raldes.data.response.TvSeriesDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeriesService {

    @GET("trending/tv/day")
    suspend fun getTrendingTvSeries(@Query("page") page: Int): SeriesResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTvSeries(@Query("page") page: Int): SeriesResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAir(@Query("page") page: Int): SeriesResponse

    @GET("tv/{tv_id}")
    suspend fun getTvSeriesDetails(
        @Path("tv_id") tvSeriesId: Long,
    ): TvSeriesDetails
}