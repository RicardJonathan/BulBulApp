package com.example.bulbulapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                SearchItem(
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            item {
                FiturScreen(
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }
            item {
                MyPetsItem(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
                )
            }
            item {
                Box(
                    modifier = Modifier
                        .padding(vertical = 17.dp, horizontal = 17.dp)
                        .height(270.dp) // Atur tinggi sesuai kebutuhan
                ) {
                    GrafikBeratBadanItem()
                }

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}