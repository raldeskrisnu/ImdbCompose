package com.raldes.data.network

import com.raldes.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse
}