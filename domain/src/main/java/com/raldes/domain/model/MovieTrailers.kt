package com.raldes.domain.model

import com.raldes.domain.Constant.YOUTUBE_APP_BASE_URL
import com.raldes.domain.Constant.YOUTUBE_TRAILER_THUMBNAIL_BASE_URL
import com.raldes.domain.Constant.YOUTUBE_TRAILER_THUMBNAIL_HQ_SUFFIX
import com.raldes.domain.Constant.YOUTUBE_WEB_BASE_URL


data class MovieTrailers(
    val id: String,
    val movieId:Long,
    val key: String?,
    val name: String?
) {
    val youTubeThumbnailUrl = if (key != null) {
        YOUTUBE_TRAILER_THUMBNAIL_BASE_URL + key + YOUTUBE_TRAILER_THUMBNAIL_HQ_SUFFIX
    } else null

    val youTubeAppUrl = if (key != null) YOUTUBE_APP_BASE_URL + key else null
    val youTubeWebUrl = if (key != null) YOUTUBE_WEB_BASE_URL + key else null
}