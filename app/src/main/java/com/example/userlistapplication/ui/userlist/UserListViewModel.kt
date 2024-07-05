package com.example.userlistapplication.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.userlistapplication.data.User
import com.example.userlistapplication.network.UserProvider


class UserListViewModel(private val userProvider : UserProvider) : ViewModel() {

    companion object {
        val TAG: String = UserListViewModel::class.java.simpleName
    }

    lateinit var users: LiveData<List<User>>

    fun iniViewModel() {
        users = userProvider.fetchUsers()
    }
}