package com.raldes.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteTableDb::class], version = 1, exportSchema = false)
abstract class MovieDb: RoomDatabase() {

    abstract val movieDao: MovieDao
}