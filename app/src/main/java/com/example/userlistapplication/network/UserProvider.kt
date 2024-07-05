package com.example.userlistapplication.network

import androidx.lifecycle.LiveData
import com.example.userlistapplication.data.User

interface UserProvider {
    fun fetchUsers(): LiveData<List<User>>
}

//    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
//
//    private val retrofit: Retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    private val userApiService: UserApiService by lazy {
//        retrofit.create(UserApiService::class.java)
//    }
//
//    fun fetchUsers() : LiveData<List<User>> {
//        return liveData(Dispatchers.IO) {
//            try {
//                val response = userApiService.getUsers().execute()
//                if (response.isSuccessful) {
//                    response.body()?.let { emit(it) }
//                } else {
//                    Log.e(UserListViewModel.TAG, "Request failed with code: ${response.code()}")
//                }
//            } catch (e: Exception) {
//                Log.e(UserListViewModel.TAG, "Network request failed", e)
//            }
//        }
//    }
//}
