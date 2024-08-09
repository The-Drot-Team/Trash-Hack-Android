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
    val myPushResponse_users: MutableLiveData<Response<Users>> = MutableLiveData()
    val myRegisterResponse: MutableLiveData<Response<CResponse>> = MutableLiveData()

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
    fun pushPostUsers(
        id: Int,
        email: String,
        passwordhash: String,
        fullname: String,
        role: String,
        organizationid: Int,
        done: Int,
        score: Int,
        current: String
    ) {
        viewModelScope.launch {
            val response = repository.pushPostUsers(id, email, passwordhash, fullname, role, organizationid, done, score, current)
            myPushResponse_users.value = response
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
            myRegisterResponse.value = response
        }
    }
}