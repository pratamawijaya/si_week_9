package com.pratama.restapi.data.response

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResponse>,
    @SerializedName("total_pages")
    val totalPage: Int,
    @SerializedName("total_results")
    val totalResult: Int
)
