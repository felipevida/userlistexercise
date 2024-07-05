package com.example.userlistapplication.network

import com.example.userlistapplication.data.User
import retrofit2.Call
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    fun getUsers(): Call<List<User>>

}