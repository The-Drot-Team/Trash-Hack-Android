package com.example.trashhack.viewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trashhack.model.*
import com.example.trashhack.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    //val myResponse_posts: MutableLiveData<Posts> = MutableLiveData()
    val myResponse_users: MutableList<Users> = mutableListOf<Users>()
    //lateinit var myResponse_users: Array<Users> //= mutableListOf<Users>()
    val myCResponse: MutableLiveData<Response<CResponse>> = MutableLiveData()
    //val myErrorResponse: MutableLiveData<Response<ErrorResponse>> = MutableLiveData()
    val myStringResponse: MutableLiveData<Response<String>> = MutableLiveData()

    /*
    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse_posts.value = response
        }
    }
     */
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
            val resp = repository.register(email, password, fullname, role, organizationid)
            myStringResponse.value = resp
        }
    }

    fun devregister(
        email: String,
        password: String,
        fullname: String,
        role: String,
        organizationid: Int
    ) {
        viewModelScope.launch {
            val response = repository.devregister(email, password, fullname, role, organizationid)
            myStringResponse.value = response
        }
    }


    fun delete(requesteduser: Users) {
        viewModelScope.launch {
            val response = repository.delete(
                com.example.trashhack.functions.data_manipulation.deletionrequesteduser.email,
                com.example.trashhack.functions.data_manipulation.deletionrequesteduser.password_hash,
                com.example.trashhack.functions.data_manipulation.deletionrequesteduser.fullname,
                com.example.trashhack.functions.data_manipulation.deletionrequesteduser.role,
                com.example.trashhack.functions.data_manipulation.deletionrequesteduser.organization_id
            )
            myStringResponse.value = response
        }
    }
    fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val response = repository.login(email, password)
            myStringResponse.value = response
        }
    }

    fun getRole() {
        viewModelScope.launch {
            val response = repository.getRole()
            myStringResponse.value = response
        }
    }
}