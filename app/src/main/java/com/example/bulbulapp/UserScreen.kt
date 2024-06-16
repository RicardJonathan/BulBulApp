package com.example.bulbulapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bulbulapp.viewmodel.UserViewModel
import com.example.bulbulapp.model.User

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.users.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Users",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        users.forEach { user ->
            Text(
                text = "${user.name} - ${user.email}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    val sampleUsers = listOf(
        User("1", "Alice", "alice@example.com"),
        User("2", "Bob", "bob@example.com"),
        User("3", "Charlie", "charlie@example.com")
    )
    val viewModel = UserViewModel().apply {
        setSampleUsers(sampleUsers)
    }
    UserScreen(viewModel)
}
