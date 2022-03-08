package com.example.tmdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdb.data.model.Results
import com.example.tmdb.data.network.MovieService
import com.example.tmdb.data.repository.MovieRepository
//import com.example.tmdb.ui.main.adapter.ClickEventHandler
import com.example.tmdb.ui.main.adapter.MovieAdapter
import com.example.tmdb.ui.main.viewadapter.MainViewModel
import com.example.tmdb.ui.main.viewadapter.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),MovieAdapter.OnMovieClickListener {
    lateinit var mainViewModel :MainViewModel
    lateinit var bundle :Bundle
    private val movies1 by lazy { mainViewModel.movies }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = MovieRepository(MovieService.movieInstance)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.movies.observe(this, Observer {
            Log.d("vijay",it.results.toString())
            val adapter = MovieAdapter(it.results,this)
            rvMovies.adapter = adapter
            rvMovies.layoutManager= GridLayoutManager(this, 3)
        })

    }

    override fun onMovieClick(movie2: Results) {
        Log.d("checking", movie2.toString())
        Intent(this,SecondActivity::class.java).also {
            it.putExtra("data",movie2)
            startActivity(it)
        }
    }



//    override fun forwardClick(view: List<Results>) {
//
//        Intent(this,SecondActivity::class.java).also {
//            it.putExtra("data",view)
//            startActivity(it)
//        }
//    }
}