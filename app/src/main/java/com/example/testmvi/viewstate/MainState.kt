package com.example.testmvi.viewstate

import com.example.testmvi.data.model.User

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    object SearchNotStartedYet: MainState()// if true, we have the search not started yet

    data class Users(val user: List<User>) : MainState()
    data class Error(val error: Throwable) : MainState()
}