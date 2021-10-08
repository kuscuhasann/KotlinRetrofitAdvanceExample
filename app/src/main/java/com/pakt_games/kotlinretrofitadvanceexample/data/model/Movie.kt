package com.pakt_games.kotlinretrofitadvanceexample.data.model

data class Movie(
    val title : String,
    val release_date : String,
    val vote_average : Double,
    val vote_count : Int,
    val overview: String?,
    val backdrop_path : String,
    val poster_path : String
)