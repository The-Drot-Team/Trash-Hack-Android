package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trashhack.functions.data_manipulation.readhash
import java.io.File
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {
    // TODO: make it bring a user to the menu they belong to

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var hash: String
        lateinit var intent: Intent

        try {
            hash = readhash(this).subSequence(0, 3).toString() // TODO: format conf file to a json-like file
        } catch (e: FileNotFoundException) {
            intent = Intent(this, SignUpPage::class.java)
        }
        when (hash) {
            "DEV" -> {
                intent = Intent(this, DevMainMenu::class.java)
                //setContentView(R.layout.activity_dev_main_menu)
            }
            "   " -> { // if user has logged out
                intent = Intent(this, SignUpPage::class.java)
            }
            else -> {
                Toast.makeText(this, "INVALID HASH: New hash will be generated, please try again.", Toast.LENGTH_SHORT).show()
                // post or get request to the server for a new hash
            }
        }

        startActivity(intent)
        this.finish()
    }

    fun tologinpage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        val intent = Intent(this, LoginPage::class.java)
        startActivity(intent)
        this.finish()
    }
    fun tosignuppage(view: View?) {
        // setContentView(R.layout.activity_sign_up_page)
        val intent = Intent(this, SignUpPage::class.java)
        startActivity(intent)
        this.finish()
    }

}