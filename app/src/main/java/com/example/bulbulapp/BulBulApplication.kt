package com.example.bulbulapp

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class BulBulApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            // Inisialisasi Firebase
            Firebase.initialize(this)
            Log.d("MyApplication", "Firebase initialized successfully.")
        } catch (e: Exception) {
            Log.e("MyApplication", "Firebase initialization failed.", e)
        }
    }
}
