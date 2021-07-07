package com.example.testmvi.data.api

import com.example.testmvi.data.model.Result
import com.example.testmvi.data.model.User
import io.reactivex.Observable

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override fun getUsers(): Observable<Result> {
        return apiService.getUsers()
    }

}