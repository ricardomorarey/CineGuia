package com.ricardomorarey.sporteventmadrid.retrofit

import com.ricardomorarey.sporteventmadrid.retrofit.models.SportEvents
import retrofit2.Call
import retrofit2.http.GET

interface MadridEventDBService {

    @GET("212504-0-agenda-actividades-deportes.json")
    fun getPopularMovies(): Call<SportEvents>

}