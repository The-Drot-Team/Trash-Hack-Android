package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.trashhack.functions.data_manipulation.userhash
import com.example.trashhack.functions.data_manipulation.readhash
import com.example.trashhack.functions.data_manipulation.userrole
import com.example.trashhack.functions.navigation.navigationhub
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {
    lateinit var progresstext: TextView
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        progresstext = findViewById(R.id.progresstext)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        lateinit var intent: Intent// = Intent(this, SignUpPage::class.java)
        super.onCreate(savedInstanceState)
        userrole.value = "   "
        // hash reading
        progresstext.setText(R.string.loading)
        try {
            userhash.value = readhash(this) // TODO: format conf file to a json-like file
            Toast.makeText(this, userhash.value, Toast.LENGTH_SHORT).show()
            Log.i("HASH", userhash.value ?: "   ")
        } catch (e: FileNotFoundException) {
            Log.i("ERROR", "NO SUCH FILE")
        }
        userhash.observe(this, Observer {
            progresstext.setText(R.string.reading_hash)
        })
        // request to the server
        progresstext.setText(R.string.retrieving_role)

        viewModel.getRole()
        viewModel.myStringResponse.observe(this, Observer {
            response ->
            if (response.code() != 200) {
                Log.i("ERROR", "ROLE ERROR")
                intent = Intent(this, SignUpPage::class.java)
                startActivity(intent)
                this.finish()
            } else {
                userrole.value = response.body()
            }
        })

        userrole.observe(this, Observer {
            Toast.makeText(this, userrole.value, Toast.LENGTH_SHORT).show()
            progresstext.setText(R.string.changing_layout)
            navigationhub(this, userrole.value!!)
            this.finish()
        })

    }
}