package com.ricardomorarey.cineguia.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ricardomorarey.cineguia.repository.TheMovieDBRepository
import com.ricardomorarey.cineguia.retrofit.Movie

class MovieViewModel: ViewModel() {

    private var theMovieDBRepository: TheMovieDBRepository
    private var popularMovies: LiveData<List<Movie>>

    init {
        theMovieDBRepository = TheMovieDBRepository()
        popularMovies = theMovieDBRepository?.popularMovies()!!
    }

    fun getPopularMovies(): LiveData<List<Movie>>{
        return popularMovies
    }

}