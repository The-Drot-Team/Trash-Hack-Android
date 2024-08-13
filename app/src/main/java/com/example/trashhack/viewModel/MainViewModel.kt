package com.example.trashhack.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trashhack.model.*
import com.example.trashhack.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse_posts: MutableLiveData<Posts> = MutableLiveData()
    val myResponse_users: MutableLiveData<Users> = MutableLiveData()
    val myCResponse: MutableLiveData<Response<CResponse>> = MutableLiveData()

    fun getPosts() {
        viewModelScope.launch {
            val response = repository.getPosts()
            myResponse_posts.value = response
        }
    }
    fun getUsers() {
        viewModelScope.launch {
            val response = repository.getUsers()
            myResponse_users.value = response
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
    fun registerDevs(
        email: String,
        password: String,
        fullname: String,
        role: String,
        organizationid: Int
    ) {
        viewModelScope.launch {
            val response = repository.registerDevs(email, password, fullname, role, organizationid)
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