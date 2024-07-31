package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory

class SignUpPage : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    var result: String = ""
    // 'in' prefix for 'input'
    lateinit var inemail: EditText
    lateinit var inpassword: EditText
    lateinit var insurname: EditText
    lateinit var inname: EditText
    lateinit var inpatronymic: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        inemail = findViewById(R.id.email_input)
        inpassword = findViewById(R.id.password_input)
        insurname = findViewById(R.id.surname_input)
        inname = findViewById(R.id.name_input)
        inpatronymic = findViewById(R.id.patronymic_input)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
    fun signup(view: View?) {
        //TODO: get rid of the unnecessary spaces in the string.
        viewModel.pushPostUsers(0, inemail.text.toString(), inpassword.text.toString(), insurname.text.toString().plus(inname.text.toString().plus(inpatronymic.text.toString())),"NONE", 0, 0, 0, "NONE")
        viewModel.myPushResponse_users.observe(this, Observer{
                response -> result = response.body().toString()//resulttext.setText(response.email)
        })
        Log.i("RESPONSE", result)
        // server check
        // if ok changes the layout
    }
}