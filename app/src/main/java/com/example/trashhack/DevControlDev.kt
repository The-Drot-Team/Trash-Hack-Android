package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.trashhack.model.UsersAdapter
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory

//import androidx.recyclerview.widget.RecyclerView.Recycler

class DevControlDev : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    //lateinit var recycler: recyclerView.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_control_dev)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

    }
    fun refresh(view: View?) {
        viewModel.getDevs(this)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UsersAdapter(viewModel.myResponse_users)
    }
    fun todevregistrationpage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        val intent = Intent(this, DevSignUp::class.java)
        startActivity(intent)
    }

}
