package com.pakt_games.kotlinretrofitadvanceexample.data.repository

import com.pakt_games.kotlinretrofitadvanceexample.data.api.ApiHelper

class BaseRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}