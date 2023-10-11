package com.pratama.restapi.data.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val id: Int?,
    val overview: String?,
    val popularity: Float?,
    @SerializedName("poster_path")
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    @SerializedName("vote_average")
    val voteAverage: Float?
)
