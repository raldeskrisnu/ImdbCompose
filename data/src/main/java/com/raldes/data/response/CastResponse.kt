package com.raldes.data.response

import com.google.gson.annotations.SerializedName

data class CastResponse(
    @SerializedName("id")
    val id: Long?,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String
)