package com.example.trashhack.functions.navigation

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
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