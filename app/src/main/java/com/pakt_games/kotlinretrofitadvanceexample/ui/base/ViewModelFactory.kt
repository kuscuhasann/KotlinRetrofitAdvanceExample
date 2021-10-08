package com.pakt_games.kotlinretrofitadvanceexample.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pakt_games.kotlinretrofitadvanceexample.data.api.ApiHelper
import com.pakt_games.kotlinretrofitadvanceexample.data.repository.RetrofitCalismaRepository
import com.pakt_games.kotlinretrofitadvanceexample.ui.viewmodel.RetrofitCalismaViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RetrofitCalismaViewModel::class.java)) {
            return RetrofitCalismaViewModel(RetrofitCalismaRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}