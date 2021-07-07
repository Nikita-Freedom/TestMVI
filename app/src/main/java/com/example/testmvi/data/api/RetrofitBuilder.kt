package com.example.testmvi.data.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



object RetrofitBuilder
{
    private const val BASE_URL = "https://reqres.in/api/"
    fun getRetrofit(): ApiService {
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiService::class.java)

    }
}








//object RetrofitBuilder
//{
//    private const val BASE_URL = "https://test.mockapi.io/"
//    private fun getRetrofit() = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(MoshiConverterFactory.create())
//        .build()
//    val apiService: ApiService =
//        getRetrofit().create(ApiService::class.java)
//}