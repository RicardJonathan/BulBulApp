package com.example.bulbulapp

import com.example.bulbulapp.model.LoginRequest
import com.example.bulbulapp.model.RegisterRequest
import com.example.bulbulapp.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun login(email: String, password: String, callback: (ApiService.LoginResponse?, String?) -> Unit) {
    val request = LoginRequest(email, password)
    RetrofitInstance.api.login(request).enqueue(object : Callback<ApiService.LoginResponse> {
        override fun onResponse(call: Call<ApiService.LoginResponse>, response: Response<ApiService.LoginResponse>) {
            if (response.isSuccessful) {
                callback(response.body(), null)
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                callback(null, errorMessage)
            }
        }

        override fun onFailure(call: Call<ApiService.LoginResponse>, t: Throwable) {
            callback(null, t.message)
        }
    })
}
fun register(username: String, email: String, password: String, callback: (ApiService.RegisterResponse?, String?) -> Unit) {
    val request = RegisterRequest(username, email, password)
    RetrofitInstance.api.register(request).enqueue(object : Callback<ApiService.RegisterResponse> {
        override fun onResponse(call: Call<ApiService.RegisterResponse>, response: Response<ApiService.RegisterResponse>) {
            if (response.isSuccessful) {
                callback(response.body(), null)
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                callback(null, errorMessage)
            }
        }

        override fun onFailure(call: Call<ApiService.RegisterResponse>, t: Throwable) {
            callback(null, t.message)
        }
    })
}