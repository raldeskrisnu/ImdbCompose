package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoriteMoviesUseCase @Inject constructor(private val movieImpl: MovieImpl) {

    suspend operator fun invoke(): Flow<List<Movie>> {
        return movieImpl.getAllFavMovie()
    }
}