package com.raldes.domain

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"
    private const val IMAGE_SIZE_W185 = "w185"
    private const val IMAGE_SIZE_W780 = "w780"

    const val CAST_AVATAR_URL = IMAGE_BASE_URL + IMAGE_SIZE_W185
    const val CAST_IMDB_URL = "https://www.imdb.com/name/"
    const val POSTER_URL = IMAGE_BASE_URL + IMAGE_SIZE_W185
    const val BACKDROP_URL = IMAGE_BASE_URL + IMAGE_SIZE_W780

    const val YOUTUBE_APP_BASE_URL = "vnd.youtube:"
    const val YOUTUBE_WEB_BASE_URL = "https://www.youtube.com/watch?v="
    const val YOUTUBE_TRAILER_THUMBNAIL_BASE_URL = "https://img.youtube.com/vi/"
    const val YOUTUBE_TRAILER_THUMBNAIL_HQ_SUFFIX = "/hqdefault.jpg"

    const val API_KEY = "321e3c990bf5421f1e48f2584df867e9"

}