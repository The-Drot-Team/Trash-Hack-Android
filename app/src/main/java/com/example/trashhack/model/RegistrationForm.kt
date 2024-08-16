package com.example.trashhack.model

import com.example.trashhack.model.loggedin.LoggedInUser

data class RegistrationForm(
    val email: String,
    val password: String,
    val fullname: String,
    val role: String,
    val organization_id: Int,
    val user: LoggedInUser
)
