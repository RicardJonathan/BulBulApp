package com.example.bulbulapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    val selectedItem = remember { mutableStateOf(NavigationItem.Home) }
    val onItemSelected: (NavigationItem) -> Unit = { item ->
//        selectedItem.value = item
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                SearchItem() // Consider adding internal padding in SearchItem composable
            }
            item {
                FiturScreen() // Consider adding internal padding in FiturScreen composable
            }
            item {
                MyPetsItem(
                    modifier = Modifier.padding(horizontal = 16.dp) // Only horizontal padding here
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
//        NavigationBar(
//            items = listOf(NavigationItem.Home, NavigationItem.Chat, NavigationItem.Profile, NavigationItem.Settings, NavigationItem.About),
//            selected = selectedItem.value,
//            onItemSelected = onItemSelected
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}