package com.example.trashhack.repository

import com.example.trashhack.api.RetrofitInstance
import com.example.trashhack.model.Posts

class Repository {
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getposts()
    }
}