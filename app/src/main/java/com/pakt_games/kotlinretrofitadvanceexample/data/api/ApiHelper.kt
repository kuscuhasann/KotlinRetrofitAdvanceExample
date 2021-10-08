package com.pakt_games.kotlinretrofitadvanceexample.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getMovies() = apiService.getMovies()
}