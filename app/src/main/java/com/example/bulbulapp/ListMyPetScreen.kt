package com.example.bulbulapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.component.TopBarCreteMyPetItem
import androidx.compose.runtime.mutableStateOf

data class Pet(val name: String, val age: String, val weight: String, val imageRes: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMyPetScreen(pets: List<Pet>, navController: NavController) {
    val selectedScreen = remember { mutableStateOf(Screen.ListMyPetScreen as Screen) } // Menggunakan Screen.ListMyPetScreen

    Scaffold(
        modifier = Modifier.padding(16.dp),
        topBar = {
            TopBarCreteMyPetItem(
                navController = navController,
                selectedScreen = selectedScreen
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            pets.forEach { pet ->
                PetItem(pet = pet, navController = navController)
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
    }
}

@Composable
fun PetItem(pet: Pet, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate(Screen.DetailPetsScreen.route + "/${pet.name}")
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = pet.imageRes),
                contentDescription = pet.name,
                modifier = Modifier.size(64.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = pet.name)
                Text(text = "Umur ${pet.age}")
                Text(text = "Berat ${pet.weight}")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.DetailPetsScreen.route + "/${pet.name}")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8066))
            ) {
                Text("Lihat", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListMyPetScreenPreview() {
    val pets = remember {
        listOf(
            Pet("BulBul", "1 tahun", "3 kg", R.drawable.bulbulpet1),
            Pet("BulBul 2", "1 tahun", "3 kg", R.drawable.bulbulpet2)
        )
    }
    ListMyPetScreen(pets = pets, navController = rememberNavController())
}
