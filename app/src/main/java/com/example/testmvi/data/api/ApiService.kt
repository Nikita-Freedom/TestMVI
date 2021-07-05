package com.example.testmvi.data.api
import com.example.testmvi.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}