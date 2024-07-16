package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // TODO: make it bring a user to the menu they belong to
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun tologinpage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        val intent = Intent(this,LoginPage::class.java)
        startActivity(intent)
    }
    fun tosignuppage(view: View?) {
        // setContentView(R.layout.activity_sign_up_page)
        val intent = Intent(this,SignUpPage::class.java)
        startActivity(intent)
    }
}