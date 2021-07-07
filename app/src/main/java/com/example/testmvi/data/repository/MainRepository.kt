package com.example.testmvi.data.repository

import com.example.testmvi.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    fun getUsers() = apiHelper.getUsers()
}