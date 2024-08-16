package com.example.trashhack.functions.data_manipulation

import android.content.Context
import java.io.File
import com.example.trashhack.functions.navigation.tosignuppage

// Functions to manipulate user data (configuration files, requests, etc.)

fun logout(context: Context) {
    File(context.cacheDir.path, "trash-hack.conf").writeText("   ")
    tosignuppage(context)
}

fun readrole(context: Context): String {
    return File(context.cacheDir.path, "trash-hack.conf").readText(Charsets.UTF_8).subSequence(0, 3).toString()
}

fun writerole(context: Context, role: String) {
    File(context.cacheDir.path, "trash-hack.conf").writeText(role)
}
fun writeinfo(context: Context, info: String) {
    File(context.cacheDir.path, "trash-hack_user.conf").writeText(info)
}
fun readinfo(context: Context): String {
    return File(context.cacheDir.path, "trash-hack_user.conf").readText(Charsets.UTF_8)
}