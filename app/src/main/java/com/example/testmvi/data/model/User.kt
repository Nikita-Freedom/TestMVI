package com.example.testmvi.data.model
import com.squareup.moshi.Json
import java.util.ArrayList


data class User(
    @Json(name = "id") val id: Int = 0,
    @Json(name = "email") val email: String = "",
    @Json(name = "first_name") val name: String = "",
    @Json(name = "last_name") val lastname: String = "",
    @Json(name = "avatar") val avatar: String = "" )

data class Result (
    val items: ArrayList<User>)
