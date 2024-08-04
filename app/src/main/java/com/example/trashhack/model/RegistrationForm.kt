package com.example.trashhack.model

data class RegistrationForm(
    val email: String,
    val password: String,
    val fullname: String,
    val role: String,
    val organization_id: Int
)
