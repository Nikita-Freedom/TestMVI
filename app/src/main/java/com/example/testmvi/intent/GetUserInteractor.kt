package com.example.testmvi.intent

import com.example.testmvi.data.repository.MainRepository
import com.example.testmvi.viewstate.MainState
import io.reactivex.Observable

class GetUserInteractor(private val repo: MainRepository) {


    //get and update users
    fun getUser(searchString: String): Observable<MainState> {
        return repo.getUsers()
            .map { result ->
                MainState.Users(result.items) as MainState
            }
            .startWith(MainState.Loading)
            .onErrorReturn { MainState.Error(it) }
    }

}