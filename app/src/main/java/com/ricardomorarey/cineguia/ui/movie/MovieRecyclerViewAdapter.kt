package com.ricardomorarey.cineguia.ui.movie

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import coil.transform.CircleCropTransformation
import com.ricardomorarey.cineguia.R
import com.ricardomorarey.cineguia.common.Constants
import com.ricardomorarey.cineguia.retrofit.Movie

class MovieRecyclerViewAdapter() : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_moview_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = movies[position]
        holder.tvTitle.text = item.title
        holder.tvRating.text = item.vote_average.toString()
        holder.imageFilm.load(Constants.IMAGE_BASE_URL + item.poster_path){
            crossfade(true)
            placeholder(R.drawable.ic_notifications_black_24dp)
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount(): Int = movies.size
    fun setData(popularMovies: List<Movie>?) {
        movies = popularMovies!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val tvRating: TextView = view.findViewById(R.id.tv_rating)
        val imageFilm: ImageView = view.findViewById(R.id.iv_film)
    }
}