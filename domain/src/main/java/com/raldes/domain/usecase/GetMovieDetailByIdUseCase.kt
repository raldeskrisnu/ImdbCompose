package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.MovieDetails
import javax.inject.Inject

class GetMovieDetailByIdUseCase @Inject constructor(
    private val movieImpl: MovieImpl) {

    suspend operator fun invoke(movieId: Long): MovieDetails {
        return movieImpl.getMovieDetailsById(movieId)
    }
}