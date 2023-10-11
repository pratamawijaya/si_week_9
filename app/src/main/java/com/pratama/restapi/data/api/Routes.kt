package com.pratama.restapi.data.api

import com.pratama.restapi.data.response.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Routes {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Query("language") lang: String = "en-EN",
        @Query("page") page: Int
    ): NowPlayingResponse


}