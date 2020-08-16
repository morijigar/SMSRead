package com.example.myapplication.ws


import com.example.apifetch.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface APIInterface {


    /* @GET("facts.json")
     suspend fun getPosts() : FactRes*/

    @Headers("Authorization: Client-ID 137cda6b5008a7c")
    @GET("search/{page}")
    suspend fun getPosts(@Path("page") page: String, @Query("q") key: String): ApiResponse
}