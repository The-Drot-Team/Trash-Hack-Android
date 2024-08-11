package com.example.trashhack

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.trashhack.functions.data_manipulation.*



class DevMainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_main_menu)
    }
    fun logout(view: View?) {
        logout(this)
        this.finish()
    }
}