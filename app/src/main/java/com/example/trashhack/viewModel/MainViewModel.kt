package com.example.trashhack.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trashhack.model.*
import com.example.trashhack.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {
    val myResponse_posts: MutableLiveData<Posts> = MutableLiveData()
    val myResponse_users: MutableLiveData<Users> = MutableLiveData()

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
}