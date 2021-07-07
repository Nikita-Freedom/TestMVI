package com.example.testmvi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmvi.data.model.User
import com.example.testmvi.intent.MainIntent
import com.example.testmvi.intent.GetUserInteractor
import com.example.testmvi.intent.UserView
import com.example.testmvi.viewstate.MainState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch



class MainViewModel(
    private val getUserInteractor: GetUserInteractor,
    ) : ViewModel(), UserView
{

    val userIntent = MainIntent.FetchUser

    private val loading: PublishSubject<Boolean>? = null
    private val persons: PublishSubject<List<User>>? = null
    private val loadpersonsCommand: PublishSubject<List<User>>? = null






    fun search() {
        getUserInteractor.getUser()
    }

    init {
        handleIntent()
    }
    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchUser -> fetchUser()
                }
            }
        }
    }
    private fun fetchUser()
    {
        search()
    }

    override fun searchIntent(): Observable<String> {
        TODO("Not yet implemented")
    }

    override fun render(mainState: MainState?) {

    }
}