package com.esoxjem.movieguide.movies.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

internal class ApiKeyInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()
        val url = originalUrl.newBuilder()
                .addQueryParameter("api_key", "<API KEY>")
                .build()

        val requestBuilder = originalRequest.newBuilder()
                .url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}