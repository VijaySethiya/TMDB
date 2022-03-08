package com.example.tmdb.ui.main.viewadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb.data.model.MovieList
import com.example.tmdb.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MovieRepository):ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO ) {
            repository.getPopularMovies("en-US", 1)
        }
    }
    val movies : LiveData<MovieList>
    get() = repository.movies

}