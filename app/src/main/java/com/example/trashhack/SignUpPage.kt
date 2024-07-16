package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpPage : AppCompatActivity() {
    // 'in' prefix for 'input'
    lateinit var inemail: String
    lateinit var inpassword: String
    lateinit var insurname: String
    lateinit var inname: String
    lateinit var inpatronymic: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        inemail = findViewById<View?>(R.id.email_input).toString()
        inpassword = findViewById<View?>(R.id.password_input).toString()
        insurname = findViewById<View?>(R.id.surname_input).toString()
        inname = findViewById<View?>(R.id.name_input).toString()
        inpatronymic = findViewById<View?>(R.id.patronymic_input).toString()
    }
    fun signup(view: View?) {
        // server check
        // if ok changes the layout
    }
}