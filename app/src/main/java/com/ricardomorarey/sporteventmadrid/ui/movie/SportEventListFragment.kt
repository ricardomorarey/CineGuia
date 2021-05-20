package com.ricardomorarey.sporteventmadrid.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ricardomorarey.sporteventmadrid.R
import com.ricardomorarey.sporteventmadrid.retrofit.models.Graph


class SportEventListFragment : Fragment() {

    private lateinit var sportEventViewModel: SportEventViewModel
    private lateinit var moviewRecyclerViewAdapter: SportEventRecyclerViewAdapter
    private  var sportEvents: List<Graph> = ArrayList()

    private var columnCount = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_moview_list_list, container, false)

        //Obtenemos el viewmodel
        sportEventViewModel = ViewModelProvider(this).get(SportEventViewModel::class.java)

        moviewRecyclerViewAdapter = SportEventRecyclerViewAdapter()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = moviewRecyclerViewAdapter
            }
        }
        //Observer de las peliculas
        sportEventViewModel.getSportEvents().observe(viewLifecycleOwner, Observer {
            sportEvents = it
            moviewRecyclerViewAdapter.setData(sportEvents)
        })

        return view
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
                SportEventListFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}