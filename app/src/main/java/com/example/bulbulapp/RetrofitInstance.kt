package com.example.bulbulapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitInstance {

    // Define the logging interceptor
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Define the OkHttpClient and add the logging interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Create the Retrofit instance using the OkHttpClient
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/users?page=1") // Replace with your actual base URL
            .client(client) // Add the client with the interceptor to Retrofit
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Create the API service
    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
