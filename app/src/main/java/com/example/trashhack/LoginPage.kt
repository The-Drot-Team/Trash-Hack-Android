package com.example.trashhack

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.functions.*
import com.example.trashhack.functions.data_manipulation.*
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import java.io.File
import java.io.FileOutputStream

class LoginPage : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    /*
    var result: String = ""
    var result_bool: Boolean = true
     */

    // 'in' prefix for 'input'
    lateinit var inemail: EditText
    lateinit var inpassword: EditText
    lateinit var debug: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        inemail = findViewById(R.id.email_input)
        inpassword = findViewById(R.id.password_input)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
    fun signin(view: View?) {
        if (removespaces(inemail.text.toString()) == "" ||
            removespaces(inpassword.text.toString()) == "") {
            Toast.makeText(this, "You have an empty field", Toast.LENGTH_SHORT).show()
            return
        }
        if (checkForInternet(this).not()) {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            return
        }

        // server check
        viewModel.login(
            removespaces(inemail.text.toString()),
            removespaces(inpassword.text.toString())
        )
        viewModel.myCResponse.observe(this, Observer{
            response -> val result = response.body()?.message ?: "No response. Please try again."
            val result_bool = response.body()?.error ?: true
            if (result_bool) {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            } else { // if ok changes the layout
                Toast.makeText(this, "Signed In Successfully", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Welcome back!", Toast.LENGTH_SHORT).show()

                writehash(this, result)

                var intent = Intent(this, MainActivity::class.java)
                val hash = result.subSequence(0, 3)
                when (hash) {
                    "DEV" -> {
                        intent = Intent(this, DevMainMenu::class.java)
                        //setContentView(R.layout.activity_dev_main_menu)
                    }
                    else -> {
                        Toast.makeText(this, "INVALID HASH: New hash will be generated, please try again.", Toast.LENGTH_SHORT).show()
                        // post or get request to the server for a new hash
                    }
                }

                Toast.makeText(this, readhash(this), Toast.LENGTH_SHORT).show()
                startActivity(intent)
                this.finish()
            }
        })
    }
    fun tosignuppage(view: View?) {
        val intent = Intent(this,SignUpPage::class.java)
        startActivity(intent)
        this.finish()
    }
}