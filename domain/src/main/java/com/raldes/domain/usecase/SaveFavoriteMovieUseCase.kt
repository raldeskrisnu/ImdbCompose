package com.raldes.domain.usecase

import com.raldes.domain.implement.MovieImpl
import com.raldes.domain.model.Movie
import javax.inject.Inject

class SaveFavoriteMovieUseCase @Inject constructor(private val movieImpl: MovieImpl) {

    suspend operator fun invoke(movie: Movie) {
        return movieImpl.saveFavMovie(movie)
    }
}