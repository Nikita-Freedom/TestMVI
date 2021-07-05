package com.example.testmvi.data.api

import com.example.testmvi.data.model.User

interface ApiHelper {
    suspend fun getUsers(): List<User>
}