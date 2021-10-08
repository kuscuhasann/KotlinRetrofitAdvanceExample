package com.pakt_games.kotlinretrofitadvanceexample.ui.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pakt_games.kotlinretrofitadvanceexample.data.repository.BaseRepository
import com.pakt_games.kotlinretrofitadvanceexample.utils.Resource
import kotlinx.coroutines.Dispatchers

class BaseViewModel(private val baseRepository: BaseRepository) : ViewModel() {
    
}