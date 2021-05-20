package com.ricardomorarey.sporteventmadrid.repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ricardomorarey.sporteventmadrid.common.MyApp
import com.ricardomorarey.sporteventmadrid.retrofit.MadridEventDBClient
import com.ricardomorarey.sporteventmadrid.retrofit.MadridEventDBService
import com.ricardomorarey.sporteventmadrid.retrofit.models.Graph
import com.ricardomorarey.sporteventmadrid.retrofit.models.SportEvents
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MaddridEventDBRepository {

    var madridEventDBService: MadridEventDBService? =  null
    var madridEventDBClient: MadridEventDBClient? = null
    var sportEvents: MutableLiveData<List<Graph>>? = null

    init {
        madridEventDBClient = MadridEventDBClient.instance
        madridEventDBService = madridEventDBClient?.getTheMovieDBService()
        sportEvents = popularMovies()
    }

    fun popularMovies(): MutableLiveData<List<Graph>>? {
        if (sportEvents == null){
            sportEvents = MutableLiveData<List<Graph>>()
        }

        val call: Call<SportEvents>? = madridEventDBService?.getPopularMovies()
        call?.enqueue(object : Callback<SportEvents>{
            override fun onResponse(call: Call<SportEvents>, response: Response<SportEvents>) {
                if (response.isSuccessful){
                    sportEvents?.value = response.body()?.graph
                }
            }

            override fun onFailure(call: Call<SportEvents>, t: Throwable) {
                Toast.makeText(MyApp.instance, "Error en la llamada", Toast.LENGTH_LONG).show()
            }

        })



        return sportEvents
    }

}