package com.pratama.restapi.data.api

import com.pratama.restapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    private val TOKEN = BuildConfig.API_KEY

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $TOKEN").build()
        return chain.proceed(request)
    }
}