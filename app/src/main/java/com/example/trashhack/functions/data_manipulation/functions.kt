package com.example.trashhack.functions.data_manipulation

import android.content.Context
import android.content.Intent
import com.example.trashhack.SignUpPage
import java.io.File

// Functions to manipulate user data (configuration files, requests, etc.)

fun logout(context: Context) {
    File(context.cacheDir.path, "trash-hack.conf").writeText("   ")
    val intent = Intent(context, SignUpPage::class.java)
    context.startActivity(intent)
}

fun readhash(context: Context): String {
    return File(context.cacheDir.path, "trash-hack.conf").readText(Charsets.UTF_8)
}

fun writehash(context: Context, result: String) {
    File(context.cacheDir.path, "trash-hack.conf").writeText(result)
}