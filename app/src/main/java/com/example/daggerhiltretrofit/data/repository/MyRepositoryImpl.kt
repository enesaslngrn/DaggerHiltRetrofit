package com.example.daggerhiltretrofit.data.repository

import android.app.Application
import android.util.Log
import com.example.daggerhiltretrofit.R
import com.example.daggerhiltretrofit.data.remote.MyApi
import com.example.daggerhiltretrofit.domain.repository.MyRepository
import com.example.daggerhiltretrofit.model.Post
import retrofit2.Response

class MyRepositoryImpl(
    private val api : MyApi,
    private val appContext : Application
) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        Log.d("MyRepositoryImpl","MyRepositoryImpl'dan geliyorum: App name: $appName")
    }

    override suspend fun getPost(): Response<Post> {
        return api.getPost()
    }
}