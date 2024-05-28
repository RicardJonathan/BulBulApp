package com.example.bulbulapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPetsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    androidx.compose.material.IconButton(onClick = { /* Handle back navigation */ }) {
                        androidx.compose.material.Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    Button(onClick = { /* Handle my pets */ }) {
                        Text("My Pets", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* Handle create */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White)
                    ) {
                        Text("Create", color = Color.Black)
                    }
                },
                modifier = Modifier.background(Color(0xFFFF8066))
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Halo, Pawrents!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFF8066)
            )
            Text(
                text = "Ayo, daftarkan Pets kamu",
                fontSize = 15.sp,
                color = Color(0xFFFF8066)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.petsnew), // Replace with your actual image resource
                contentDescription = "Cats in a car",
                modifier = Modifier.size(550.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {  },
                modifier = Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF8066) // Warna dalam format hex
                ),
                shape = RoundedCornerShape(4.dp) // Menambahkan shape dengan sudut melengkung
            ) {
                Text(
                    text = "Daftar",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 17.sp
                    ),
                    textAlign = TextAlign.Center
                )

            }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun MyPetsScreenPreview() {
    MyPetsScreen()
}
