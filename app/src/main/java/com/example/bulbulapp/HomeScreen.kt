package com.example.bulbulapp

import WeightChartItem
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bulbulapp.component.FiturScreen
import com.example.bulbulapp.component.MyPetsItem
import com.example.bulbulapp.component.SearchItem
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.model.BeratBadan
import com.example.bulbulapp.model.MyPets
import com.example.bulbulapp.model.Profile
import com.example.bulbulapp.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    profiles: List<Profile> = DummyData.listProfile,
    myPetsList: List<MyPets> = DummyData.listMyPets,
    beratBadanList: List<BeratBadan> = DummyData.listBeratBadan // Added parameter for beratBadanList
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.background(Color.White) // Mengubah warna latar belakang menjadi putih
    ) {
        item {
            // Konten lain sebelum FiturScreen
        }

        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth() // Menyesuaikan dengan kiri dan kanan layar
            ) {
                items(profiles, key = { it.id }) {
                    SearchItem(profile = it) { profileId ->
                        navController.navigate(Screen.Home.route + "/$profileId")
                    }
                }
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding sesuai kebutuhan
                    .wrapContentHeight()
                    .background(Color.White) // Mengubah warna latar belakang menjadi putih
            ) {
                FiturScreen(navController = navController, modifier = Modifier.align(Alignment.Center))
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding sesuai kebutuhan
                    .wrapContentHeight()
                    .background(Color.White) // Mengubah warna latar belakang menjadi putih
            ) {
                MyPetsItem(myPetsList = myPetsList, modifier = Modifier.align(Alignment.Center))
            }
        }

        // Tambahkan WeightChartItem di bawah MyPetsItem
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp) // Padding sesuai kebutuhan
                    .wrapContentHeight()
                    .background(Color.White) // Mengubah warna latar belakang menjadi putih
            ) {
                WeightChartItem(beratBadanList = beratBadanList, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
