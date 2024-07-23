package com.example.trashhack.repository

import com.example.trashhack.api.RetrofitInstance
import com.example.trashhack.model.*

class Repository {
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getposts()
    }
    suspend fun getUsers(): Users {
        return RetrofitInstance.api.getusers()
    }
}