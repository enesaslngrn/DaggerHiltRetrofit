package com.example.daggerhiltretrofit.domain.repository

import com.example.daggerhiltretrofit.data.remote.MyApi
import com.example.daggerhiltretrofit.model.Post
import retrofit2.Response

interface MyRepository {

    suspend fun getPost() : Response<Post>
}