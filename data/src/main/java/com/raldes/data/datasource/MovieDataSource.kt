package com.raldes.data.datasource

import com.raldes.data.network.MovieService
import com.raldes.data.response.mappers.asMovieDetail
import com.raldes.data.response.mappers.asMovies
import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.Movies
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val movieService: MovieService) {

    suspend fun getPopularMovies(page: Int): Movies {
        return movieService.getPopularMovies(page).asMovies()
    }

    suspend fun getMovieDetailById(movieId: Long): MovieDetails {
        return movieService.getMovieDetails(movieId).asMovieDetail()
    }

    suspend fun getSearchMovie(query: String, page: Int): Movies {
        return movieService.searchMovies(query, page).asMovies()
    }
}