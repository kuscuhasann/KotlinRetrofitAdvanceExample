package com.pakt_games.kotlinretrofitadvanceexample.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
}