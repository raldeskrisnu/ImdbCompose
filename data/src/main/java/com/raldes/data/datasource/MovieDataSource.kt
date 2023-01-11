package com.raldes.data.datasource

import com.raldes.data.network.MovieService
import com.raldes.data.response.mappers.asMovies
import com.raldes.domain.model.Movies
import javax.inject.Inject

class MovieDataSource @Inject constructor(private val movieService: MovieService) {

    suspend fun getPopularMovies(page: Int): Movies {
        return movieService.getPopularMovies(page).asMovies()
    }
}