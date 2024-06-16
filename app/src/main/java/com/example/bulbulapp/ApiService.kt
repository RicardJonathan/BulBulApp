package com.example.bulbulapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body request: com.example.bulbulapp.model.LoginRequest): Call<LoginResponse>

    @POST("register")
    fun register(@Body request: com.example.bulbulapp.model.RegisterRequest): Call<RegisterResponse>


    data class LoginRequest(val email: String, val password: String)
    data class LoginResponse(val token: String, val user: User)
    data class RegisterRequest(val username: String, val email: String, val password: String)
    data class RegisterResponse(val id: String, val username: String, val email: String)
    data class User(val id: String, val name: String, val email: String)
}
