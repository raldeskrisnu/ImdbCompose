package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMoviesByIdUseCase @Inject constructor(private val movieImpl: MovieImpl) {

    suspend operator fun invoke(movieId: Long): Flow<Movie?> {
        return movieImpl.getFavMovie(movieId)
    }
}