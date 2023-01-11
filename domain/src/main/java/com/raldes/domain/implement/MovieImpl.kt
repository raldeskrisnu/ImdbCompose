package com.raldes.domain.implement

import com.raldes.domain.model.Movies

interface MovieImpl {
    suspend fun getPopularMovies(page: Int): Movies

}