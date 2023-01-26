package com.raldes.data.response

import com.google.gson.annotations.SerializedName

data class CreditsResult(
    @SerializedName("cast")
    val cast: List<CastResponse>?
)