package com.example.trashhack.model

data class RegistrationForm(
    val fullname: String,
    val email: String,
    val password: String,
    val role: String,
    val organizationid: Int
)
