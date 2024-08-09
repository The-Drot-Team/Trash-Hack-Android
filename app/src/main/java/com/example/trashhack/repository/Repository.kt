package com.example.trashhack.repository

import com.example.trashhack.api.RetrofitInstance
import com.example.trashhack.model.*
import retrofit2.Response

class Repository {
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getposts()
    }
    suspend fun getUsers(): Users {
        return RetrofitInstance.api.getusers()
    }
    suspend fun pushPostUsers(
        id: Int,
        email: String,
        passwordhash: String,
        fullname: String,
        role: String,
        organizationid: Int,
        done: Int,
        score: Int,
        current: String
    ): Response<Users> {
        var temp: Users = Users(id, email, passwordhash, fullname, role, organizationid, done, score, current)
        return RetrofitInstance.api.pushpost(temp)
    }

    suspend fun register(
        email: String,
        password: String,
        fullname: String,
        role: String,
        organizationid: Int
    ) : Response<CResponse>
    {
        val temp: RegistrationForm = RegistrationForm(
            email,
            password,
            fullname,
            role,
            organizationid
        )
        return RetrofitInstance.api.register(temp)
    }
}