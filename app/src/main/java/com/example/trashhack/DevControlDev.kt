package com.example.trashhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trashhack.model.Users

import com.example.trashhack.model.UsersAdapter
import com.example.trashhack.functions.data_manipulation.deletionrequesteduser
import com.example.trashhack.repository.Repository
import com.example.trashhack.viewModel.MainViewModel
import com.example.trashhack.viewModelFactory.MainViewModelFactory
import okhttp3.internal.notify

//import androidx.recyclerview.widget.RecyclerView.Recycler

class DevControlDev : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var usersAdapter: UsersAdapter
    //lateinit var recycler: recyclerView.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_control_dev)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        usersAdapter = UsersAdapter(viewModel.myResponse_users)
        recyclerView.adapter = usersAdapter

        //usersAdapter.notifyDataSetChanged()
    }
    fun refresh(view: View?) {
        viewModel.getDevs(this)
        //usersAdapter.notify()
        //recyclerView.addOnItemTouchListener()
        //recyclerView.Recycler().clear()
        //recyclerView.swapAdapter(UsersAdapter(viewModel.myResponse_users), true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this, 1)
        //
    }
    fun todevregistrationpage(view: View?) {
        // setContentView(R.layout.activity_login_page)
        val intent = Intent(this, DevSignUp::class.java)
        startActivity(intent)
    }

    //val obs =
    fun deleteuser(view: View?) {
        viewModel.delete(deletionrequesteduser)

        viewModel.myCResponse.observe(this, Observer{
                response ->
            val result = response.body()?.message ?: "No response. Please try again."
            val result_bool = response.body()?.error ?: true

            if (result_bool) {
                Toast.makeText(this, "ERROR: ".plus(result), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            }
        })
    }

}
