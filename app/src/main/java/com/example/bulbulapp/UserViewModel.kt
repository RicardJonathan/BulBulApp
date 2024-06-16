package com.example.bulbulapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bulbulapp.model.User

class UserViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        // Initialize with some data if needed
        _users.value = listOf(
            User("1", "Alice", "alice@example.com"),
            User("2", "Bob", "bob@example.com"),
            User("3", "Charlie", "charlie@example.com")
        )
    }

    // Method to set sample users for preview
    fun setSampleUsers(sampleUsers: List<User>) {
        _users.value = sampleUsers
    }
}
