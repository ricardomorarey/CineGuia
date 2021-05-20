package com.ricardomorarey.sporteventmadrid.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class MadridEventDBInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        request = request.newBuilder()
            .addHeader("Content_Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(request)
    }
}