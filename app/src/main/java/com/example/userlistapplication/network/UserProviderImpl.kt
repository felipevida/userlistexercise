package com.example.userlistapplication.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.userlistapplication.data.User
import com.example.userlistapplication.ui.userlist.UserListViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserProviderImpl : UserProvider {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Companion.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val userApiService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }

    override fun fetchUsers(): LiveData<List<User>> {
        return liveData(Dispatchers.IO) {
            try {
                val response = userApiService.getUsers().execute()
                if (response.isSuccessful) {
                    response.body()?.let { emit(it) }
                } else {
                    Log.e(UserListViewModel.TAG, "Request failed with code: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e(UserListViewModel.TAG, "Network request failed", e)
            }
        }
    }
}
