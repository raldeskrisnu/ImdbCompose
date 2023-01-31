package com.raldes.data.repository

import com.raldes.data.datasource.local.FavoriteTableDb
import com.raldes.data.datasource.local.MovieDbDataSource
import com.raldes.data.datasource.local.asMovie
import com.raldes.data.datasource.local.asMovies
import com.raldes.data.datasource.service.MovieDataSource
import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.Movie
import com.raldes.domain.model.MovieDetails
import com.raldes.domain.model.MoviesMapperResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDataSource: MovieDataSource,
                                          private val movieDbDataSource: MovieDbDataSource): MovieImpl {

    override suspend fun getPopularMovies(page: Int): MoviesMapperResponse {
        return movieDataSource.getPopularMovies(page)
    }

    override suspend fun getMovieDetailsById(movieId: Long): MovieDetails {
        return movieDataSource.getMovieDetailById(movieId)
    }

    override suspend fun getSearchMovies(query: String, page: Int): MoviesMapperResponse {
        return movieDataSource.getSearchMovie(query, page)
    }

    override suspend fun getAllFavMovie(): Flow<List<Movie>> {
        return movieDbDataSource.getAllFavoriteMovies().map {
            it.asMovies()
        }
    }

    override suspend fun getFavMovie(id: Long): Flow<Movie?> {
        return movieDbDataSource.getFavoriteMovie(id).map {
            it?.asMovie()
        }
    }

    override suspend fun saveFavMovie(movie: Movie): Long {
        return movieDbDataSource.saveFavoriteMovie(
            FavoriteTableDb(
                id = movie.id,
                overview = movie.overview,
                releaseDate = movie.releaseDate!!,
                posterPath = movie.posterUrl,
                backdropPath = movie.backdropUrl,
                voteAverage = movie.voteAverage,
                voteCount = movie.voteAccount,
                isFavorite = true,
                title = movie.title
            )
        )
    }

    override suspend fun deleteFavMovie(movieId: Long): Int {
        return movieDbDataSource.deleteMovies(movieId)
    }
}