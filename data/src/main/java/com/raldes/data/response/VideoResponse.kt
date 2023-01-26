package com.raldes.data.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("key")
    val key: String)