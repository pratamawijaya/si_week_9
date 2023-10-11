package com.pratama.restapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pratama.restapi.R
import com.pratama.restapi.data.response.MovieResponse
import com.squareup.picasso.Picasso

class NowPlayingAdapter(private val listMovie: List<MovieResponse>) :
    RecyclerView.Adapter<NowPlayingAdapter.NowPlayingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_now_playing, parent, false)
        return NowPlayingHolder(view)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: NowPlayingHolder, position: Int) {
        holder.bindView(listMovie[position])
    }

    inner class NowPlayingHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(movie: MovieResponse) {
            // inisiasi view
            val imgPoster = view.findViewById<ImageView>(R.id.imgPoster)
            val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
            val tvRating = view.findViewById<TextView>(R.id.tvRating)
            val tvOverview = view.findViewById<TextView>(R.id.tvOverview)


            tvTitle.text = movie.title
            tvRating.text = "${movie.voteAverage}"
            tvOverview.text = movie.overview

            val path = buildPosterPath(movie.posterPath)

            // load image from url into imageview
            Picasso.get().load(path).into(imgPoster)

        }

        private fun buildPosterPath(posterPath: String?): String {
            return "https://image.tmdb.org/t/p/w500/$posterPath"
        }

    }


}