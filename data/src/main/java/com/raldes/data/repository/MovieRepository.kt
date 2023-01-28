package com.raldes.data.repository

import com.raldes.data.datasource.MovieDataSource
import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.Movies
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDataSource: MovieDataSource): MovieImpl {

    override suspend fun getPopularMovies(page: Int): Movies {
        return movieDataSource.getPopularMovies(page)
    }

    override suspend fun getMovieDetailsById(movieId: Long): MovieDetails {
        return movieDataSource.getMovieDetailById(movieId)
    }

    override suspend fun getSearchMovies(query: String, page: Int): Movies {
        return movieDataSource.getSearchMovie(query, page)
    }
}