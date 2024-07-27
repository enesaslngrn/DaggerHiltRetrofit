package com.example.daggerhiltretrofit.data.remote

import com.example.daggerhiltretrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("/posts/1")
    suspend fun getPost() : Response<Post>

}