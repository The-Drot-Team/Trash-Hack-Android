package com.example.trashhack.model

data class DevRegForm(
    val email: String,
    val password: String,
    val fullname: String,
    val role: String,
    val organization_id: Int,
    val hash: String //val user: LoggedInUser
)
