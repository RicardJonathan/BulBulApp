package com.example.bulbulapp.component

import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.Divider
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bulbulapp.data.ProdukListData
import com.example.bulbulapp.navigation.Screen
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.bulbulapp.data.LayananListData

@Composable
fun ContentLayananScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            LayananGridList(navController)
        }
        item {
            LayananLazyRow(navController)
        }
    }
}

@Composable
fun LayananGridList(navController: NavController) {
    val layanans = LayananListData.listLayananItems
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),  // Adjust the height as needed
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(layanans.size) { index ->
            LayananCard(
                layanan = layanans[index],
                navController = navController,
            )
        }
    }
}

@Composable
fun LayananLazyRow(navController: NavController) {
    val layananListItems = LayananListData.listLayananItems
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Produk Teratas",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Lihat lainnya",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFF8066),
                modifier = Modifier
                    .clickable { navController.navigate(Screen.Layanan.route) }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(layananListItems.take(3)) { layanan ->
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate(Screen.LayananDetails.createRoute(layanan.id))
                        },
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Image(
                            painter = painterResource(layanan.photo),
                            contentDescription = "layanan image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp),
                            contentScale = ContentScale.Fit
                        )
                        Divider(color = Color.LightGray, thickness = 1.dp)
                        Column(modifier = Modifier.padding(8.dp)) {
                            LayananTags(tag = layanan.tag)
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = layanan.name,
                                color = Color.Gray,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            val primaryColor = Color(0xFFFF8066)
                            Button(
                                onClick = {
                                    navController.navigate(Screen.LayananDetails.createRoute(layanan.id))
                                },
                                modifier = Modifier
                                    .height(35.dp)
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = primaryColor
                                )
                            ) {
                                Text(
                                    text = "Lihat Produk",
                                    fontSize = 12.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun PreviewlayananLazyRow() {
//    val navController = rememberNavController()
//    layananLazyRow(navController = navController)
//}


@Preview
@Composable
fun previewLayananContent (){
    ContentLayananScreen(navController = rememberNavController())
}