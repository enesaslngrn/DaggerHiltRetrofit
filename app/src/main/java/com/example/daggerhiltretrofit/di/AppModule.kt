package com.example.daggerhiltretrofit.di

import android.app.Application
import com.example.daggerhiltretrofit.data.remote.MyApi
import com.example.daggerhiltretrofit.data.repository.MyRepositoryImpl
import com.example.daggerhiltretrofit.domain.repository.MyRepository
import com.example.daggerhiltretrofit.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyApi() : MyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api : MyApi,app : Application) : MyRepository{
        return MyRepositoryImpl(api,app)
    }
}