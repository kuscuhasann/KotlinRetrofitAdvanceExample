package com.pakt_games.kotlinretrofitadvanceexample.data.api

import com.google.gson.annotations.SerializedName
import com.pakt_games.kotlinretrofitadvanceexample.data.model.Movie

data class MovieListResponse (
    @SerializedName("results") val filmler : ArrayList<Movie>
)