package com.raldes.data.network

import com.raldes.data.response.MovieDetailResponse
import com.raldes.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse

    @GET("movie/{id}?append_to_response=videos,credits")
    suspend fun getMovieDetails(@Path("id") id: Long): MovieDetailResponse
}