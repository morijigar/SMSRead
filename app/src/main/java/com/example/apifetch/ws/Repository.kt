package com.example.myapplication.ws

import com.example.apifetch.ws.RetrofitClientInstance

class Repository {

    var client = RetrofitClientInstance.getRetrofitInstance().create(APIInterface::class.java)

    suspend fun getData(page: String, q: String) = client.getPosts(page, q)

}