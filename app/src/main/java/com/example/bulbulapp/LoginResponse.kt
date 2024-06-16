package com.example.bulbulapp

import com.google.firebase.firestore.auth.User


data class LoginResponse(val token: String, val user: User)