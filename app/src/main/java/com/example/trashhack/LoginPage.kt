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
    // 'in' prefix for 'input'
    lateinit var inemail: String
    lateinit var inpassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        inemail = findViewById<View?>(R.id.email_input).toString()
        inpassword = findViewById<View?>(R.id.password_input).toString()
    }
    fun signin(view: View?) {
        // server check
        // if ok changes the layout
    }
    fun tosignuppage(view: View?) {
        val intent = Intent(this,SignUpPage::class.java)
        startActivity(intent)
    }
}