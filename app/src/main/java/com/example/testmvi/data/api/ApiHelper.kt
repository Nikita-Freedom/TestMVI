package com.example.testmvi.data.api

import com.example.testmvi.data.model.Result
import io.reactivex.Observable


interface ApiHelper {
    fun getUsers(): Observable<Result>
}