package com.raldes.movie_compose.di

import com.raldes.data.repository.MovieRepository
import com.raldes.domain.implement.MovieImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieImpl(movieRepository: MovieRepository): MovieImpl = movieRepository
}