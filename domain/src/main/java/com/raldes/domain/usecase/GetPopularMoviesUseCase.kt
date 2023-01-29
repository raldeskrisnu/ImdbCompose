package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.MoviesMapperResponse
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieImpl: MovieImpl) {

    suspend operator fun invoke(page: Int): MoviesMapperResponse {
        return movieImpl.getPopularMovies(page)
    }
}