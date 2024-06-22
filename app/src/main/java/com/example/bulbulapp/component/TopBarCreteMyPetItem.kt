package com.example.bulbulapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.navigation.Screen
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

data class SelectorItem(
    val text: String,
    val screen: Screen,
    val backgroundColor: Color,
    val textColor: Color
)

@Composable
fun TopBarCreteMyPetItem(navController: NavController, selectedScreen: MutableState<Screen>, modifier: Modifier = Modifier) {
    val gridData = listOf(
        SelectorItem(
            text = "My Pets",
            screen = Screen.ListMyPetScreen,
            backgroundColor = if (selectedScreen.value == Screen.ListMyPetScreen) Color(0xFFFF9985) else Color(0xFFEEF1F4),
            textColor = if (selectedScreen.value == Screen.ListMyPetScreen) Color.White else Color(0xFFFF8066)
        ),
        SelectorItem(
            text = "Create",
            screen = Screen.CreateMyPetscreen,
            backgroundColor = if (selectedScreen.value == Screen.CreateMyPetscreen) Color(0xFFFF9985) else Color(0xFFEEF1F4),
            textColor = if (selectedScreen.value == Screen.CreateMyPetscreen) Color.White else Color(0xFFFF8066)
        )
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(30.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ) {
        // Icon untuk kembali ke halaman utama
        IconButton(
            onClick = {
                // Handle back to home navigation
                navController.navigate(Screen.Home.route)
            },
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xffeef1f4))
        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Kembali",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }

        // Menampilkan item selector
        gridData.forEach { item ->
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(item.backgroundColor)
                    .clickable {
                        selectedScreen.value = item.screen
                        navController.navigate(item.screen.route)
                    }
            ) {
                Text(
                    text = item.text,
                    color = item.textColor,
                    modifier = Modifier
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                        .align (Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopBarCreteMyPetItem() {
    val navController = rememberNavController()
    val selectedScreen = remember { mutableStateOf(Screen.ListMyPetScreen as Screen) }

    TopBarCreteMyPetItem(navController = navController, selectedScreen = selectedScreen)
}