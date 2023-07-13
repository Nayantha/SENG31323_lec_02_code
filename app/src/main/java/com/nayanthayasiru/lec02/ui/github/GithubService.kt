package com.nayanthayasiru.lec02.ui.github

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users")
    suspend fun users(): Response<List<GithubUser>>
}

data class GithubUser(var login: String, var avatar_url: String)
