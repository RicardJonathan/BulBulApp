package com.example.bulbulapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") } // State variable for email
    var password by remember { mutableStateOf("") } // State variable for password

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Welcome Text
        Text(
            text = "Selamat Datang",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color(0xFFFF8066) // Orange color for welcome text
            ),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 17.dp)
        )

        // Description Text
        Text(
            text = "Silahkan login di sini",
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 18.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it }, // Update email state on change
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it }, // Update password state on change
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            visualTransformation = PasswordVisualTransformation() // Hide password characters
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Forgot Password Text
        Text(
            text = "Lupa password?",
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 16.sp,
                color = Color(0xFFFF8066) // Orange color for "Lupa password?" text
            ),
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))


        // Tombol Masuk
        Button(
            onClick = { /* Handle create new account logic */ }, // Implementasikan logika pembuatan akun di sini
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8066)), // Warna latar belakang oranye
            shape = RoundedCornerShape(4.dp) // Sudut tombol dibuat melengkung dengan radius 4.dp
        ) {
            Text(text = "Masuk", color = Color.White) // Teks putih untuk tombol
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Create Account Button
        Button(
            onClick = { /* Handle create new account logic */ }, // Implementasikan logika pembuatan akun di sini
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8066)), // Warna latar belakang oranye
            shape = RoundedCornerShape(4.dp) // Sudut tombol dibuat melengkung dengan radius 4.dp
        ) {
            Text(text = "Buat Akun Baru")
        }
    }
    }


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
