package com.pakt_games.kotlinretrofitadvanceexample.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pakt_games.kotlinretrofitadvanceexample.data.repository.RetrofitCalismaRepository
import com.pakt_games.kotlinretrofitadvanceexample.utils.Resource
import kotlinx.coroutines.Dispatchers

class RetrofitCalismaViewModel(private val retrofitCalismaRepository: RetrofitCalismaRepository) : ViewModel() {
    fun getMovies() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = retrofitCalismaRepository.getMovies()))
        } catch (exception : Exception) {
            emit(Resource.error(data = null,message = exception.message ?: "Error Occurred!"))
        }
    }
}