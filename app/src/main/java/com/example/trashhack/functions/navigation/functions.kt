package com.example.trashhack.functions.navigation

import android.content.Context
import android.content.Intent
import com.example.trashhack.DevMainMenu
import com.example.trashhack.LoginPage
import com.example.trashhack.SignUpPage

fun tologinpage(context: Context) {
    // setContentView(R.layout.activity_login_page)
    val intent = Intent(context, LoginPage::class.java)
    context.startActivity(intent)
    //this.finish()
}
fun tosignuppage(context: Context) {
    // setContentView(R.layout.activity_sign_up_page)
    val intent = Intent(context, SignUpPage::class.java)
    context.startActivity(intent)
    //this.finish()
}
fun todevmenupage(context: Context) {
    // setContentView(R.layout.activity_sign_up_page)
    val intent = Intent(context, DevMainMenu::class.java)
    context.startActivity(intent)
    //this.finish()
}
fun navigationhub(context: Context, role: String) {
    when (role) {
        "DEV" -> todevmenupage(context)
        "STU" -> println("no such menu yet")
        else -> tosignuppage(context)
    }
}