package com.example.bulbulapp.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.component.ImagePlaceholder
import com.example.bulbulapp.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var notificationMessage by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ilustrasi_loginscreen),
            contentDescription = "Ilustrasi login screen",
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
                .padding(10.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Welcome Text
        Text(
            text = "Selamat Datang",
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color(0xFFFF8066)
            ),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        )

        // Description Text
        Text(
            text = "Silahkan login di sini",
            style = MaterialTheme.typography.bodySmall.copy(
                fontSize = 18.sp,
                color = Color.Gray
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it }, // Update password state on change
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            visualTransformation = PasswordVisualTransformation() // Hide password characters
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Row to align "Lupa password?" to the right
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            ClickableText(
                text = AnnotatedString("Lupa password?"),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 16.sp,
                    color = Color(0xFFFF8066)
                ),
                onClick = {
                    navController.navigate(Screen.PasswordChangeScreen.route)
                },
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Login Button
        Button(
            onClick = {
                coroutineScope.launch {
                    val auth = FirebaseAuth.getInstance()
                    try {
                        val result = auth.signInWithEmailAndPassword(email, password)
                        notificationMessage = "Login berhasil."
                        saveUserToRealtimeDatabase(email, password)
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.LoginScreen.route) { inclusive = true }
                        }
                    } catch (e: Exception) {
                        notificationMessage = "Login gagal: ${e.message}"
                        Log.e("Firebase", "Login gagal: ", e)
                    }
                }
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8066)
            ),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text("Masuk")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Buat Akun Button
        Button(
            onClick = {
                navController.navigate(Screen.RegisterScreen.route)
            },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8066)
            ),
            shape = RoundedCornerShape(4.dp) // Rounded corners
        ) {
            Text("Buat Akun Baru")
        }

        Spacer(modifier = Modifier.height(16.dp))
        notificationMessage?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 14.sp,
                    color = if (it.startsWith("Login berhasil")) Color.Green else Color.Red
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

private fun saveUserToRealtimeDatabase(email: String, password: String) {
    val database = Firebase.database
    val myRef = database.getReference("bulbuluser")

    val user = hashMapOf(
        "email" to email,
        "password" to password,
    )
    myRef.push().setValue(user).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            Log.d("Firebase", "Data berhasil disimpan.")
        } else {
            Log.e("Firebase", "Gagal menyimpan data: ", task.exception)
        }
    }.addOnFailureListener { exception ->
        Log.e("Firebase", "Exception: ", exception)
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}