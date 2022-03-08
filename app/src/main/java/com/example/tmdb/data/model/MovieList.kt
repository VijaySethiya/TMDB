package com.example.tmdb.data.model

import java.io.Serializable

data class MovieList(
    val page: Int,
    val results: List<Results>,
    val total_pages: Int,
    val total_results: Int
):Serializable
