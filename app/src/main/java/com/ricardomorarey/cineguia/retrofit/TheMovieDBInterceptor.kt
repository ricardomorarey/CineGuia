package com.ricardomorarey.cineguia.retrofit

import android.provider.SyncStateContract
import com.ricardomorarey.cineguia.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class TheMovieDBInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        //añadimos parametros
        val urlWithParams = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(Constants.URL_PARAM_API_KEY, Constants.APY_KEY)
            .addQueryParameter(Constants.URL_PARAM_LANGUAGE, "es-ES")
            .build()

        var request = chain.request()

        request = request.newBuilder()
            .url(urlWithParams)
            .addHeader("Content_Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(request)
    }
}