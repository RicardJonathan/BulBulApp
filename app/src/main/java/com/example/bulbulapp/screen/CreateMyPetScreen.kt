package com.example.bulbulapp.screen

import TipeMyPetsItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bulbulapp.component.FotoMyPets
import com.example.bulbulapp.component.ItemInputDataHewanSaya
import com.example.bulbulapp.component.KondisiBadanItem
import com.example.bulbulapp.component.TingkatAktivitasItem
import com.example.bulbulapp.component.TopBarCreteMyPetItem
import com.example.bulbulapp.component.UkuranBadanItem

class CreateMyPetScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateMyPetContent()
        }
    }
}

@Composable
fun SaveButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        androidx.compose.material.Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xffff8066)
            ),
            modifier = Modifier.align(Alignment.Center)
        ) {
            androidx.compose.material.Text(text = "Selesai", color = Color.White)
        }
    }
}

@Composable
fun CreateMyPetContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Set background color to white
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                TopBarCreteMyPetItem(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation
            }
            item {
                TipeMyPetsItem(Modifier.fillMaxWidth()) // Call TipeMyPetsItem here
            }
            item {
                Spacer(modifier = Modifier.height(8.dp)) // Spacer for separation
            }
            item {
                FotoMyPets(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(16.dp)) // Spacer for separation
            }
            item {
                ItemInputDataHewanSaya(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(16.dp)) // Larger spacer for more separation
            }
            item {
                UkuranBadanItem(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                TingkatAktivitasItem(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                KondisiBadanItem(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(20.dp)) // Add some space before the button
            }
            item {
                SaveButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /* Handle save action */ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateMyPetScreenPreview() {
    CreateMyPetContent()
}