package com.example.bulbulapp.screen


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(navController: NavController) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisibility by remember { mutableStateOf(false) }
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
            painter = painterResource(R.drawable.ilustrasi_registerscreen),
            contentDescription = "Ilustrasi register screen",
            modifier = Modifier
                .width(300.dp)
                .height(250.dp)
                .padding(10.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Buat Akun",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFFC8368),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Masukan detail akun Anda",
            fontSize = 15.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(vertical = 4.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        androidx.compose.material3.Button(
            onClick = {
                coroutineScope.launch {
                    val auth = FirebaseAuth.getInstance()
                    try {
                        val result = auth.createUserWithEmailAndPassword(email.text, username.text)
                        notificationMessage = "Login berhasil."
                        saveUserToRealtimeDatabase (username.text, email.text)
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.RegisterScreen.route) { inclusive = true }
                        }
                    } catch (e: Exception) {
                        notificationMessage = "Registrasi gagal: ${e.message}"
                        Log.e("Firebase", "Registrasi gagal: ", e)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFC8368))
        ) {
            Text(
                text = "Daftar",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 17.sp
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        notificationMessage?.let {
            Text(
                text = it,
                fontSize = 10.sp,
                color = if (it.startsWith("Login berhasil"))
                    Color.Green else Color.Red,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}


private fun saveUserToRealtimeDatabase(username: String, email: String) {
    val database = Firebase.database
    val myRef = database.getReference("bulbuluser")

    val user = hashMapOf(
        "username" to username,
        "email" to email,
    )
    myRef.push().setValue(user).addOnCompleteListener { task ->
    }
}


@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    val navController = rememberNavController()
    RegistrationScreen(navController = navController)
}