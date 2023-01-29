package com.raldes.domain.implement

import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.MoviesMapperResponse

interface MovieImpl {
    suspend fun getPopularMovies(page: Int): MoviesMapperResponse
    suspend fun getMovieDetailsById(movieId: Long): MovieDetails
    suspend fun getSearchMovies(query: String, page: Int): MoviesMapperResponse

}