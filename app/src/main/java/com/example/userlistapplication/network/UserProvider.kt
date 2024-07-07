package com.example.userlistapplication.network

import androidx.lifecycle.LiveData
import com.example.userlistapplication.data.User

interface UserProvider {
    fun fetchUsers(): LiveData<List<User>>
}