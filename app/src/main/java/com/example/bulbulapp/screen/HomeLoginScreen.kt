package com.example.bulbulapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R

@Composable
fun HomeLoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 32.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Halo, Pawrents!",
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 30.sp),
            color = Color(0xFFFF8066), // Set text color to #FF8066 with alpha channel
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(R.drawable.iustrasi_overlay),
            contentDescription = "Background Image",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .padding(10.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick =  { },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8066) // Warna dalam format hex
            ),
            shape = RoundedCornerShape(4.dp) // Menambahkan shape dengan sudut melengkung
        ) {
            Text("Masuk")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick =  {  },
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF8066) // Warna dalam format hex
            ),
            shape = RoundedCornerShape(4.dp) // Menambahkan shape dengan sudut melengkung
        ) {
            Text("Buat Akun Baru")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeLoginScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        HomeLoginScreen(navController = navController)
    }
}
