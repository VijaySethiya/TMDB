package com.example.tmdb

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.tmdb.data.model.Results
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.movie_view.view.*


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
        val movies= intent.getSerializableExtra("data") as Results
        if (movies != null){
            Glide.with(this).load("$BASE_URL_IMAGE/${movies.poster_path}").into(imv1_SecondActivity);
            tv1_SecondActivity.text = movies.overview
        }

    }
}