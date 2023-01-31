package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import javax.inject.Inject

class DeleteMovieByIdUseCase @Inject constructor(private val movieImpl: MovieImpl) {

    suspend operator fun invoke(movieId: Long): Int {
        return movieImpl.deleteFavMovie(movieId)
    }
}