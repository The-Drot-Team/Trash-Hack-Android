package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trashhack.functions.data_manipulation.*
import com.example.trashhack.model.loggedin.LoggedInUser_instance


class DevMainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_main_menu)
        Toast.makeText(this, LoggedInUser_instance.toString(), Toast.LENGTH_SHORT).show()
    }
    fun logout(view: View?) {
        logout(this)
        this.finish()
    }
    fun todevcontrolpage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        val intent = Intent(this, DevControlDev::class.java)
        startActivity(intent)
    }
    fun toorganizationspage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        val intent = Intent(this, DevSignUp::class.java) // TODO: replace DevSignUp when implement organizations
        startActivity(intent)
    }
}