package com.nayanthayasiru.lec02.di

import com.nayanthayasiru.lec02.ui.github.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    @Singleton
    @Provides
    fun provideGithubService(retrofit: Retrofit):GithubService = retrofit.create(GithubService::class.java)
}