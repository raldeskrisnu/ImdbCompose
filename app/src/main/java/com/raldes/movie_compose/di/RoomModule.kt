package com.raldes.movie_compose.di

import android.content.Context
import androidx.room.Room
import com.raldes.data.datasource.local.MovieDao
import com.raldes.data.datasource.local.MovieDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): MovieDb {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDb::class.java,
            "myMovie.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: MovieDb):MovieDao = db.movieDao

    @Singleton
    @Provides
    fun provideDispatcher() = Dispatchers.IO
}