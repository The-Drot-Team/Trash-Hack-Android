package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    lateinit var inemail: EditText
    lateinit var inpassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        inemail = findViewById(R.id.email_input)
        inpassword = findViewById(R.id.password_input)
    }
    fun tosignuppage(view: View?) {
        val intent = Intent(this,SignUpPage::class.java)
        startActivity(intent)
    }
}