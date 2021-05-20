package com.ricardomorarey.sporteventmadrid.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ricardomorarey.sporteventmadrid.repository.MaddridEventDBRepository
import com.ricardomorarey.sporteventmadrid.retrofit.models.Graph

class SportEventViewModel: ViewModel() {

    private var maddridEventDBRepository: MaddridEventDBRepository
    private var sportEvents: LiveData<List<Graph>>

    init {
        maddridEventDBRepository = MaddridEventDBRepository()
        sportEvents = maddridEventDBRepository?.popularMovies()!!
    }

    fun getSportEvents(): LiveData<List<Graph>>{
        return sportEvents
    }

}