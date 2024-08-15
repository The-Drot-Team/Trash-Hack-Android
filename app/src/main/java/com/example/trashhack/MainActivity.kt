package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trashhack.functions.data_manipulation.readrole
import retrofit2.HttpException
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var intent: Intent// = Intent(this, SignUpPage::class.java)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        var role = "   "
        try {
            role = readrole(this) // TODO: format conf file to a json-like file
            Log.i("Role is", role)
        } catch (e: FileNotFoundException) {
            intent = Intent(this, SignUpPage::class.java)
            Log.i("ERROR", "NO SUCH FILE")
        }/*
        try {

        } catch (e: HttpException) {
            //
        }
        */
        when (role) {
            "DEV" -> {
                intent = Intent(this, DevMainMenu::class.java)
                //setContentView(R.layout.activity_dev_main_menu)
            }
            "   " -> { // if user has logged out or opens the app for the first time
                intent = Intent(this, SignUpPage::class.java)
            }
        }
        startActivity(intent)
        this.finish()
    }
}