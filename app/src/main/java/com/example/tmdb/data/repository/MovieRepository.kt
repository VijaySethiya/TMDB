package com.example.tmdb.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tmdb.data.model.MovieList
import com.example.tmdb.data.network.MovieInterface
import com.example.tmdb.data.network.MovieService

class MovieRepository(private val movieInterface:MovieInterface) {
    private val movieLiveData = MutableLiveData<MovieList>()
    val movies:LiveData<MovieList>
    get() = movieLiveData

    suspend fun getPopularMovies(language:String,page:Int){
        val result =movieInterface.getPopularMovie(language,page)
        if (result?.body() != null ){
            movieLiveData.postValue(result.body())
        }
    }
}