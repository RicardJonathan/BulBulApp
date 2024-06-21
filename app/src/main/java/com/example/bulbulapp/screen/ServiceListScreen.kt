package com.example.bulbulapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.component.CardlayananItem
import com.example.bulbulapp.data.DummyData

@Composable
fun ServiceListScreen(navController: NavController) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                var searchText by remember { mutableStateOf("") } // State to hold the text input

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp) // Adjust the height to fit the search bar and filter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bghome), // Your background image resource
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        TextField(
                            value = searchText,
                            onValueChange = { newText -> searchText = newText },
                            placeholder = { Text("Temukan Layanan Terbaik") },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.search1),
                                    contentDescription = "Search Icon"
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.location1),
                                    contentDescription = "Location Icon",
                                    tint = Color(0xFF000000)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Surabaya, Jawa Timur",
                                    color = Color(0xff6d6f77),
                                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium)
                                )
                            }
                            TextButton(
                                onClick = { /* TODO: Add filter logic */ },
                                colors = ButtonDefaults.textButtonColors(
                                    contentColor = Color(0xff6d6f77)
                                )
                            ) {
                                Text("Filter")
                            }
                        }
                    }
                }

                // Filter Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /* TODO: Add "Semua" filter logic */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffffa694)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Semua")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* TODO: Add "Grooming" filter logic */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffffa694)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Grooming")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { /* TODO: Add "Pet Clinic" filter logic */ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffffa694)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Pet Clinic")
                    }
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp) // Apply padding here
                ) {
                    items(DummyData.listLayanan) { layanan ->
                        CardlayananItem(
                            layanan = layanan,
                            onItemClicked = { clickedLayanan ->
                                // Handle item click here
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ServiceListScreenPreview() {
    val navController = rememberNavController()
    ServiceListScreen(navController)
}
