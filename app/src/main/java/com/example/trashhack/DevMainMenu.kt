package com.example.trashhack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity




class DevMainMenu : AppCompatActivity() {
    override fun onBackPressed() {
        finish()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_main_menu)
    }
}