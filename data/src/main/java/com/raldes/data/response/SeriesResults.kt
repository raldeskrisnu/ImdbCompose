package com.raldes.data.response

import com.google.gson.annotations.SerializedName

data class SeriesResults(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("id")
    val seriesId: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)