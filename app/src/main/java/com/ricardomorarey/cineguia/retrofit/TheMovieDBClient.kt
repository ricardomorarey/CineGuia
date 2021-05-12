package com.ricardomorarey.cineguia.retrofit

import com.google.gson.Gson
import com.ricardomorarey.cineguia.common.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class TheMovieDBClient {

    private val theMovieDBService: TheMovieDBService
    private val retrofit: Retrofit

    companion object {
        var instance: TheMovieDBClient? = null
            get() {
                if (field == null) {
                    instance = TheMovieDBClient()
                }
                return field
            }
    }


    init {
        //add interceptor
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(TheMovieDBInterceptor())

        val client = okHttpClientBuilder.build()

        //construir cliente retrofit
        retrofit = Retrofit.Builder()
                .baseUrl(Constants.CINE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        //instanciamos
        theMovieDBService = retrofit.create(TheMovieDBService::class.java)
    }

    fun getTheMovieDBService() = theMovieDBService

}