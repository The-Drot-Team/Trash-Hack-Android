package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import androidx.lifecycle.Observer
import java.io.File
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    // TODO: make it bring a user to the menu they belong to


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val hash: String = File("hash").readText(Charsets.UTF_8)
            when (hash.subSequence(0, 3)) {
                "DEV" -> {
                    intent = Intent(this, DevMainMenu::class.java)
                    //setContentView(R.layout.activity_dev_main_menu)
                }
                else -> {
                    Toast.makeText(this, "INVALID HASH: New hash will be generated, please try again.", Toast.LENGTH_SHORT).show()
                    // post or get request to the server for a new hash
                }
            }
        } catch (e: FileNotFoundException) {
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
            this.finish()
        }


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
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