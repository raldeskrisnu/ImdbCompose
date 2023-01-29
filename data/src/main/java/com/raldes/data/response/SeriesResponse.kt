package com.raldes.data.response

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<SeriesResults>,
    @SerializedName("total_pages")
    val totalPages: Int
)