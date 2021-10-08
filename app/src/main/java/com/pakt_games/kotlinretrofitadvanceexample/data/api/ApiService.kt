package com.pakt_games.kotlinretrofitadvanceexample.data.api

import com.pakt_games.kotlinretrofitadvanceexample.data.model.Movie
import retrofit2.http.GET

interface ApiService {
    @GET("popular?api_key=fcd345463f34e19075c713aef8ced4f4") suspend fun getMovies(): MovieListResponse
}