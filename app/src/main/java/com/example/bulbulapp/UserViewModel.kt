package com.example.bulbulapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bulbulapp.model.LoginResponse
import com.example.bulbulapp.model.RegisterResponse
import com.google.firebase.auth.FirebaseAuth

class UserViewModel : ViewModel() {

    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    private val _registerResponse = MutableLiveData<RegisterResponse>()
    val registerResponse: LiveData<RegisterResponse> = _registerResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val firebaseAuth = FirebaseAuth.getInstance()

    fun login(email: String, password: String) {
        _isLoading.value = true

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login successful, update UI with the signed-in user's information
                    val user = firebaseAuth.currentUser
                    _loginResponse.value = LoginResponse(success = true, message = "Login successful")
                } else {
                    // Handle login failure
                    handleLoginFailure(task.exception)
                }
                _isLoading.value = false
            }
    }

    fun handleLoginFailure(exception: Exception?) {
        val errorMessage = exception?.message ?: "Login failed"
        _loginResponse.value = LoginResponse(success = false, message = errorMessage)
    }

    fun register(username: String, email: String, password: String) {
        _isLoading.value = true

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val userId = user?.uid ?: ""
                    val userData = mapOf(
                        "username" to username,
                        "email" to email
                    )
                    _registerResponse.value = RegisterResponse(success = true, message = "Registration successful")
                } else {
                    handleRegisterFailure(task.exception)
                }
                _isLoading.value = false
            }
    }

    fun handleRegisterFailure(exception: Exception?) {
        val errorMessage = exception?.message ?: "Registration failed"
        _registerResponse.value = RegisterResponse(success = false, message = errorMessage)
    }
}
