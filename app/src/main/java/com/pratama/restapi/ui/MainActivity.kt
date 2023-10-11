package com.pratama.restapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pratama.restapi.R
import com.pratama.restapi.data.api.Network
import com.pratama.restapi.data.response.MovieResponse
import com.pratama.restapi.data.response.NowPlayingResponse
import com.pratama.restapi.ui.adapter.NowPlayingAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: NowPlayingAdapter
    private var listMovie = mutableListOf<MovieResponse>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvNowPlaying = findViewById<RecyclerView>(R.id.rvNowPlaying)
        rvNowPlaying.layoutManager = LinearLayoutManager(this)
        adapter = NowPlayingAdapter(listMovie)
        rvNowPlaying.adapter = adapter

        lifecycleScope.launch {
            val result = Network.getService(this@MainActivity).getNowPlaying(
                page = 1
            )

            Log.d("debug", "total page -> ${result.totalPage}")

            result.results.map {
                Log.d("debug", "hasilnya -> ${it.title} - ${it.overview}")
                listMovie.add(it)
            }

            // update recyclerviewnya
            adapter.notifyDataSetChanged()
        }
    }
}