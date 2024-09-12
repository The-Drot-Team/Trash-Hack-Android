package com.example.trashhack

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.R.id.role_input
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import com.example.trashhack.functions.*
import com.example.trashhack.functions.data_manipulation.userhash
import com.example.trashhack.functions.data_manipulation.userrole
import com.example.trashhack.functions.data_manipulation.writehash
import com.example.trashhack.functions.navigation.*

class SignUpPage : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    // 'in' prefix for 'input'
    lateinit var inemail: EditText
    lateinit var inpassword: EditText
    lateinit var insurname: EditText
    lateinit var inname: EditText
    lateinit var inpatronymic: EditText
    lateinit var inrole: EditText
    lateinit var organization_id: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        inemail = findViewById(R.id.email_input)
        inpassword = findViewById(R.id.password_input)
        insurname = findViewById(R.id.surname_input)
        inname = findViewById(R.id.name_input)
        inpatronymic = findViewById(R.id.patronymic_input)
        inrole = findViewById(R.id.role_input)
        //role = "DEV"
        organization_id = "1"

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
    fun signup(view: View?) {
        if (removespaces(inemail.text.toString()) == "" ||
            removespaces(inpassword.text.toString()) == "" ||
            removespaces(insurname.text.toString()) == "" ||
            removespaces(inname.text.toString()) == "") {
            Toast.makeText(this, "You have an empty field", Toast.LENGTH_SHORT).show()
            return
        }
        if (checkForInternet(this).not()) {
            Toast.makeText(this, "No internet connection", Toast.LENGTH_LONG).show()
            return
        }
        // server check
        viewModel.register(
            removespaces(inemail.text.toString()),
            removespaces(inpassword.text.toString()),
            fullname(insurname.text.toString(), inname.text.toString(), inpatronymic.text.toString()),
            inrole.text.toString(),
            organization_id.toInt()
        )
        viewModel.myStringResponse.observe(this, Observer {
                response ->
            if (response.body() == null) {
                Toast.makeText(this, "No Response", Toast.LENGTH_SHORT).show()
            } else if (response.code() != 200) {
                Toast.makeText(this, "ERROR: ".plus(response.code().toString()), Toast.LENGTH_SHORT).show()
            }  else {
                Toast.makeText(this, "Success".plus(response.body()), Toast.LENGTH_SHORT).show()
                userhash.value = response.body()
                writehash(this, userhash.value!!)
            }
        })
        // should I put it before the response observer?
        userhash.observe(this, Observer {
            userrole.value = inrole.text.toString()
            navigationhub(this, userrole.value!!)
            this.finish()
        })
    }
    fun tologinpage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        tologinpage(this)
        this.finish()
    }
}