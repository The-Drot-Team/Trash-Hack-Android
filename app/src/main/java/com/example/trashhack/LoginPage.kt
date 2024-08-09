package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.functions.onlyprefixspace
import com.example.trashhack.functions.removespaces
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory


class LoginPage : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    var result: String = ""
    // 'in' prefix for 'input'
    lateinit var inemail: EditText
    lateinit var inpassword: EditText
    lateinit var debug: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        inemail = findViewById(R.id.email_input)
        inpassword = findViewById(R.id.password_input)

        debug = findViewById(R.id.debug)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
    fun signin(view: View?) {
        if (inemail.text.toString() == "" ||
            removespaces(inpassword.text.toString()) == "") {
            Log.i("InputValidityCheck", "an empty field")
            return
        }
        viewModel.login(
            removespaces(inemail.text.toString()),
            removespaces(inpassword.text.toString()))
        viewModel.myCResponse.observe(this, Observer{
                response -> result = response.body()?.message ?: "oops"//resulttext.setText(response.email)
            debug.setText(result)
            Log.i("RESPONSE", result)
        })
        // server check
        // if ok changes the layout
    }
    fun tosignuppage() { //view: View?) {
        val intent = Intent(this,SignUpPage::class.java)
        startActivity(intent)
    }
}