package com.pakt_games.kotlinretrofitadvanceexample.data.api

import com.pakt_games.kotlinretrofitadvanceexample.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}