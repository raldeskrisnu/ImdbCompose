package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.MoviesMapperResponse
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(private val movieImpl: MovieImpl) {

    suspend operator fun invoke(query: String, page: Int): MoviesMapperResponse {
        return movieImpl.getSearchMovies(query, page)
    }
}