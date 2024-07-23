package com.example.trashhack.api

import com.example.trashhack.model.Posts
import com.example.trashhack.model.Users
import retrofit2.http.GET

interface API {
    @GET("posts/1")
    suspend fun getposts() : Posts
    @GET("users/1")
    suspend fun getusers() : Users
}