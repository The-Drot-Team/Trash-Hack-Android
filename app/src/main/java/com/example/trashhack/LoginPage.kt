package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.functions.*
import com.example.trashhack.functions.data_manipulation.*
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import com.example.trashhack.functions.navigation.tosignuppage
import com.example.trashhack.model.loggedin.LoggedInUser
import com.example.trashhack.model.loggedin.LoggedInUser_instance

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

                writerole(this, result.subSequence(0, 3).toString())

                LoggedInUser_instance.fullname = result.subSequence(4, result.length).toString()
                Toast.makeText(this, "Welcome back!\n".plus(LoggedInUser_instance.fullname), Toast.LENGTH_SHORT).show()

                var intent = Intent(this, MainActivity::class.java)
                when (readrole(this)) { // it is used as a 'role' field
                    "DEV" -> {
                        // get request to the server with the newly acquired data
                        intent = Intent(this, DevMainMenu::class.java)
                        //setContentView(R.layout.activity_dev_main_menu)
                    }
                    else -> { // idk what could've happened here
                        intent = Intent(this, SignUpPage::class.java)
                    }
                }

                Toast.makeText(this, readrole(this), Toast.LENGTH_SHORT).show()
                startActivity(intent)
                this.finish()
            }
        })
    }
    fun tosignuppage(view: View?) {
        tosignuppage(this)
        this.finish()
    }
}