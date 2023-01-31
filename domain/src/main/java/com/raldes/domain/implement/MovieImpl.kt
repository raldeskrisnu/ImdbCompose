package com.raldes.domain.implement

import com.raldes.domain.model.Movie
import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.MoviesMapperResponse
import kotlinx.coroutines.flow.Flow

interface MovieImpl {
    suspend fun getPopularMovies(page: Int): MoviesMapperResponse
    suspend fun getMovieDetailsById(movieId: Long): MovieDetails
    suspend fun getSearchMovies(query: String, page: Int): MoviesMapperResponse

    //db region
    suspend fun saveFavMovie(movie: Movie)
    suspend fun getAllFavMovie(): Flow<List<Movie>>
    suspend fun getFavMovie(id: Long): Flow<Movie?>

}