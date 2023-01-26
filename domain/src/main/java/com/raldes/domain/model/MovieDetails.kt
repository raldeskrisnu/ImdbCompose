package com.raldes.domain.model

data class MovieDetails(
     val movies: Movie,
     val genres: List<Genre>,
     val cast: List<Cast>,
     val trailers: List<MovieTrailers>)