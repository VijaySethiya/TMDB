package com.example.tmdb.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.data.model.Results
import kotlinx.android.synthetic.main.movie_view.view.*

class MovieAdapter(private val movie1:List<Results>,private val listener:OnMovieClickListener) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

//    private val clickHandler: ClickEventHandler = context as ClickEventHandler
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_view, parent, false)
        return MovieViewHolder(view)
//            .also {
//            view.setOnClickListener { clickHandler.forwardClick(movie1) }
//        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/original"
        holder.movieView.apply{
            tv1.text=movie1 [position].title
            Glide.with(this).load("$BASE_URL_IMAGE/${movie1[position].poster_path}").into(imv1);
      }

    }

    override fun getItemCount(): Int {
        return movie1.size
    }

    inner class MovieViewHolder(val movieView: View):RecyclerView.ViewHolder(movieView),View.OnClickListener
    {
        init {
            movieView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onMovieClick(movie1[position])
            }
        }

    }
    interface OnMovieClickListener{
        fun onMovieClick(movie2: Results)
    }
}

//interface ClickEventHandler {
//    fun forwardClick(movieData: List<Results>)
//}

