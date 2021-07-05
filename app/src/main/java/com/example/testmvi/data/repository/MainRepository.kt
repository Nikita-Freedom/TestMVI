package com.example.testmvi.data.repository

import com.example.testmvi.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper)
{
    suspend fun getUsers() = apiHelper.getUsers()
}