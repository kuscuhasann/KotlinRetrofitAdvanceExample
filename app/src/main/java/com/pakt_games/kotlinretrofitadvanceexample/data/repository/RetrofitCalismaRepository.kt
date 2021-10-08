package com.pakt_games.kotlinretrofitadvanceexample.data.repository

import com.pakt_games.kotlinretrofitadvanceexample.data.api.ApiHelper

class RetrofitCalismaRepository(private val apiHelper: ApiHelper) {

    suspend fun getMovies() = apiHelper.getMovies()
}