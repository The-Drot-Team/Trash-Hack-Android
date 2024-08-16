package com.example.trashhack.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trashhack.model.*
import com.example.trashhack.model.loggedin.LoggedInUser
import com.example.trashhack.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse_posts: MutableLiveData<Posts> = MutableLiveData()
    val myResponse_users: MutableList<Users> = mutableListOf<Users>()
    //lateinit var myResponse_users: Array<Users> //= mutableListOf<Users>()
    val myCResponse: MutableLiveData<Response<CResponse>> = MutableLiveData()

    fun readallemails(context: Context) {
        for (user in myResponse_users) {
            Toast.makeText(context, user.email, Toast.LENGTH_SHORT).show()
        }
    }
    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse_posts.value = response
        }
    }
    fun getDevs(context: Context) {
        try {
            viewModelScope.launch {
                val response = repository.getDevs()
                response.body()?.let { myResponse_users.addAll(it) }// = response
            }
        } catch (e: HttpException) {
            Toast.makeText(context, "Try again.", Toast.LENGTH_SHORT).show()
        }
    }
    fun register(
        email: String,
        password: String,
        fullname: String,
        role: String,
        organizationid: Int
    ) {
        viewModelScope.launch {
            val response = repository.register(email, password, fullname, role, organizationid)
            myCResponse.value = response
        }
    }
    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val response = repository.login(email, password)
            myCResponse.value = response
        }
    }
}