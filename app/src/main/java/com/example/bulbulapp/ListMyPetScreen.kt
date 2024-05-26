package com.example.bulbulapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Pet(val name: String, val age: String, val weight: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMyPetsScreen(pets: List<Pet>) {
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
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
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
        ) {
            pets.forEach { pet ->
                PetItem(pet)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun PetItem(pet: Pet) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFD3D3D3), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = pet.imageRes),
            contentDescription = pet.name,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = pet.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Umur ${pet.age}", fontSize = 16.sp)
            Text(text = "Berat ${pet.weight}", fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = { /* Handle edit */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8066))
        ) {
            Text("Edit", color = Color.White)
        }
        Spacer(modifier = Modifier.width(8.dp))
        androidx.compose.material.IconButton(onClick = { /* Handle back navigation */ }) {
            androidx.compose.material.Icon(
                Icons.Filled.Delete, contentDescription = "Delete", tint = Color(0xFFFF8066))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListMyPetsScreenPreview() {
    val pets = remember {
        listOf(
            Pet("BulBul", "1 tahun", "3 kg", R.drawable.bulbulpet1),
            Pet("BulBul 2", "1 tahun", "3 kg", R.drawable.bulbulpet2)
        )
    }
    ListMyPetsScreen(pets = pets)
}
