package com.example.bulbulapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bulbulapp.model.LoginResponse
import com.example.bulbulapp.model.RegisterResponse

class UserViewModel : ViewModel() {

    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    private val _registerResponse = MutableLiveData<RegisterResponse>()
    val registerResponse: LiveData<RegisterResponse> = _registerResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(email: String, password: String) {
        _isLoading.value = true
        // Simulate a login process
        if (email == "test@example.com" && password == "password") {
            _loginResponse.value = LoginResponse(success = true, message = "Login successful")
        } else {
            _loginResponse.value = LoginResponse(success = false, message = "Invalid credentials")
        }
        _isLoading.value = false
    }

    fun register(username: String, email: String, password: String) {
        _isLoading.value = true
        // Simulate a registration process
        // Replace with actual network request
        _registerResponse.value = RegisterResponse(success = true, message = "Registration successful")
        _isLoading.value = false
    }
}
