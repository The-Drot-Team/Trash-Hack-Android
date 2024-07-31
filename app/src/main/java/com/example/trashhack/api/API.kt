package com.example.trashhack.api

import com.example.trashhack.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface API {
    @GET("posts/1")
    suspend fun getposts() : Posts
    @GET("users/1")
    suspend fun getusers() : Users


    //@FormUrlEncoded
    @POST("post_users")
    @Headers("Content-Type: application/json")
    suspend fun pushpost(
        @Body temp: Users
    ) : Response<Users>
}