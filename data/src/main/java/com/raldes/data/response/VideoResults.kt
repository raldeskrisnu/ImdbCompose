package com.raldes.data.response

import com.google.gson.annotations.SerializedName

data class VideoResults(
    @SerializedName("results")
    val videos: List<VideoResponse>?)