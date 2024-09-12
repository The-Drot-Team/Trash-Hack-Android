package com.example.trashhack.functions.data_manipulation

import androidx.lifecycle.MutableLiveData
import com.example.trashhack.model.Users

val userhash: MutableLiveData<String> = MutableLiveData()

lateinit var deletionrequesteduser: Users
val userrole: MutableLiveData<String> = MutableLiveData()