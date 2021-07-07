package com.example.testmvi.data.api
import com.example.testmvi.data.model.Result
import com.example.testmvi.data.model.User
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import java.util.*

interface ApiService {
    @GET("users?page=2")
    fun getUsers(): Observable<Result> // Отдает на обозревание подписчикам полученные данные с сервера.

}



//interface ApiService {
//    @GET("users")
//    suspend fun getUsers(@Query("q") query: String,
//                         @Query("page") page: Int,
//                         @Query("per_page") perPage: Int): Observable<Result>
//    companion object Factory {
//        fun create(): ApiService {
//            val retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://api.github.com/")
//                .build()
//
//            return retrofit.create(ApiService::class.java);
//        }
//    }
//}