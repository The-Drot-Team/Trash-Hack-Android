package com.example.trashhack.model

data class Users (
    val id: Int,
    val email: String,
    val password_hash: String,
    val fullname: String, // Surname + Name + Patronymic
    val role: String,
    val organization_id: Int,
    val done: Int, // number of participations
    val score: Int,
    val current: String // What a user participates in right now
)