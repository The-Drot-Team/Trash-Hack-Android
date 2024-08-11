package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    var result: String = ""

    // TODO: make it bring a user to the menu they belong to
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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