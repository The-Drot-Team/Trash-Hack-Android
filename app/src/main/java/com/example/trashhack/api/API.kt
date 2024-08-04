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
    @GET("get_data/1")
    suspend fun getusers() : Users

    @POST("post_users")
    @Headers("Content-Type: application/json")
    suspend fun pushpost(
        @Body temp: Users
    ) : Response<Users>

    @POST("register")
    @Headers("Content-Type: application/json")
    suspend fun register(
        @Body temp: RegistrationForm
    ) //: Response<Users>
}