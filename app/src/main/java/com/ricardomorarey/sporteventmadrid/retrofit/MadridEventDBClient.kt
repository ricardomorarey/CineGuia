package com.ricardomorarey.sporteventmadrid.retrofit

import com.ricardomorarey.sporteventmadrid.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MadridEventDBClient {

    private val madridEventDBService: MadridEventDBService
    private val retrofit: Retrofit

    companion object {
        var instance: MadridEventDBClient? = null
            get() {
                if (field == null) {
                    instance = MadridEventDBClient()
                }
                return field
            }
    }


    init {
        //add interceptor

        val interdep = HttpLoggingInterceptor()
        interdep.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(MadridEventDBInterceptor())
            .addNetworkInterceptor(interdep)

        val client = okHttpClientBuilder.build()

        //construir cliente retrofit
        retrofit = Retrofit.Builder()
                .baseUrl(Constants.MADRID_EVENT_URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        //instanciamos
        madridEventDBService = retrofit.create(MadridEventDBService::class.java)
    }

    fun getTheMovieDBService() = madridEventDBService

}