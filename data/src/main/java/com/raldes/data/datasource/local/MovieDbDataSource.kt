package com.raldes.data.datasource.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDbDataSource @Inject constructor(
        private val movieDao: MovieDao,
        private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun saveFavoriteMovie(movie: FavoriteTableDb): Long =
         withContext(ioDispatcher) {
            movieDao.insertFavoriteMovies(movie)
        }

    suspend fun getFavoriteMovie(movieId: Long): Flow<FavoriteTableDb?> =
        withContext(ioDispatcher) {
            movieDao.getMovieById(movieId)
        }

    fun getAllFavoriteMovies(): Flow<List<FavoriteTableDb>> =
        movieDao.getAllFavoriteMovies()

    suspend fun deleteMovies(movieId: Long): Int =
        withContext(ioDispatcher) {
            movieDao.deleteMovieById(movieId)
        }

}