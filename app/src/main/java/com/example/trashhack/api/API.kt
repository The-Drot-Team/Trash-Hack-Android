package com.example.trashhack.api

import com.example.trashhack.model.Posts
import retrofit2.http.GET

interface API {
    @GET("users/1")
    suspend fun getposts() : Posts
}