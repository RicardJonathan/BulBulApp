package com.example.bulbulapp.screen

import CardGrooming
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.component.CardPetsShop
import com.example.bulbulapp.data.DummyData

@Composable
fun DetailScreenLayanan(navController: NavController, selectedServiceId: Int) {
    val selectedService = DummyData.listLayanan.find { it.id == selectedServiceId }
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Layanan",
                        color = Color(0xff6d6f77),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 1.38.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 48.dp) // Sesuaikan padding untuk memusatkan judul
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "arrow-left",
                            modifier = Modifier
                                .size(25.dp)
                                .clip(RoundedCornerShape(112.dp))
                                .background(color = Color(0xffeef1f4))
                                .padding(4.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = { paddingValues ->
            selectedService?.let { service ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp)
                        .verticalScroll(scrollState)
                ) {
                    Spacer(modifier = Modifier.size(16.dp))
                    Image(
                        painter = painterResource(id = service.photo),
                        contentDescription = service.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = service.name,
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                            modifier = Modifier.weight(1f) // Set the name to take all available space
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.bintang),
                            contentDescription = "Star Icon",
                            modifier = Modifier.size(20.dp), // Adjust icon size as needed
                            tint = Color(0xffff8066)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = service.rating,
                            color = Color(0xff545f71),
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(start = 4.dp) // Add padding between icon and rating
                        )
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Senin-Minggu",
                            color = Color(0xff545f71),
                            style = TextStyle(fontSize = 14.sp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "08:00 - 20:00",
                            color = Color.White,
                            style = TextStyle(fontSize = 11.sp),
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(Color(0xffffa694))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Tentang",
                        color = Color(0xff545f71),
                        lineHeight = 1.38.em,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = service.description,
                        style = TextStyle(fontSize = 14.sp, color = Color(0xff9ba5b7))
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Layanan",
                        color = Color(0xff545f71),
                        lineHeight = 1.38.em,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    LazyRow {
                        items(DummyData.listGrooming.size) { index ->
                            CardGrooming(
                                grooming = DummyData.listGrooming[index],
                                onItemClicked = { id ->
                                    // Handle card click
                                },
                                modifier = Modifier.padding(end = 8.dp) // Add padding between cards
                            )

                        }

                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Pet Shop", // Ganti dengan tag yang diinginkan, misalnya "Pet Shop"
                        color = Color.White,
                        style = TextStyle(fontSize = 11.sp),
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color(0xffffa694))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    LazyRow {
                        items(DummyData.listPetShop.size) { index ->
                            CardPetsShop(
                                petShop = DummyData.listPetShop[index], // Menggunakan petShop sebagai parameter
                                onItemClicked = { id ->
                                    // Handle card click
                                },
                                modifier = Modifier.padding(end = 8.dp) // Add padding between cards
                            )

                        }

                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Peta Lokasi",
                        color = Color(0xff545f71),
                        lineHeight = 1.38.em,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.maps), // Replace with your map image resource
                        contentDescription = "Map",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode("Jl.Kutai No 84, Surabaya, Jawa Timur")}")
                                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                                mapIntent.setPackage("com.google.android.apps.maps")
                                context.startActivity(mapIntent)
                            },
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Jl.Kutai No 84, Surabaya, Jawa Timur",
                        style = TextStyle(fontSize = 14.sp, color = Color(0xff9ba5b7))
                    )
                }

            } ?: Text("Layanan tidak ditemukan")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailScreenLayananPreview() {
    val navController = rememberNavController()
    val selectedServiceId = 1 // Example service ID
    DetailScreenLayanan(navController = navController, selectedServiceId = selectedServiceId)
}
