package com.example.trashhack.repository

import com.example.trashhack.api.RetrofitInstance
import com.example.trashhack.model.*
import com.example.trashhack.model.loggedin.LoggedInUser
import com.example.trashhack.model.loggedin.LoggedInUser_instance
import retrofit2.Response

class Repository {
    suspend fun getPosts(): Posts {
        return RetrofitInstance.api.getposts()
    }
    suspend fun getDevs(): Response<MutableList<Users>> {
        return RetrofitInstance.api.getdevs(LoggedInUser_instance)
    }
    /*
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
     */

    suspend fun register(
        email: String,
        password: String,
        fullname: String,
        role: String,
        organizationid: Int
    ) : Response<CResponse> {
        LoggedInUser_instance = LoggedInUser(fullname, email, password)
        val temp: RegistrationForm = RegistrationForm(
            email,
            password,
            fullname,
            role,
            organizationid
        )
        return RetrofitInstance.api.register(temp)
    }
    suspend fun registerDevs(
        email: String,
        password: String,
        fullname: String,
        role: String,
        organizationid: Int
    ) : Response<CResponse> {
        val temp: RegistrationForm = RegistrationForm(
            email,
            password,
            fullname,
            role,
            organizationid
        )
        return RetrofitInstance.api.registerDevs(temp)
    }

    suspend fun login(
        email: String,
        password: String
    ) : Response<CResponse>
    {
        LoggedInUser_instance = LoggedInUser("", email, password)
        val temp: LogInForm = LogInForm(
            email,
            password
        )
        return RetrofitInstance.api.login(temp)
    }
}