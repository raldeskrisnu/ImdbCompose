package com.raldes.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovies(movie: FavoriteTableDb): Long

    @Query("SELECT * FROM movie WHERE movie.id = :movieId")
    fun getMovieById(movieId: Long): Flow<FavoriteTableDb?>

    @Query("SELECT * FROM movie WHERE is_favorite = 1 ORDER BY title")
    fun getAllFavoriteMovies(): Flow<List<FavoriteTableDb>>

    @Query("DELETE FROM movie WHERE movie.id = :movieId")
    fun deleteMovieById(movieId: Long): Int
}