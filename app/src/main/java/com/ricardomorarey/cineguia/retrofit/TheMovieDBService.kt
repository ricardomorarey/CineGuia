package com.ricardomorarey.cineguia.retrofit

import com.ricardomorarey.cineguia.retrofit.models.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface TheMovieDBService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<PopularMoviesResponse>

}