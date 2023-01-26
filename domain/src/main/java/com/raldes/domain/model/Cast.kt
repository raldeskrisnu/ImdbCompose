package com.raldes.domain.model

import com.raldes.domain.Constant.CAST_AVATAR_URL

data class Cast(
    val id: Long,
    val movieId: Long,
    val actorName:String?,
    val imagePath:String?
) {
    val imageUrl = if(imagePath !=null) CAST_AVATAR_URL + imagePath else null
}