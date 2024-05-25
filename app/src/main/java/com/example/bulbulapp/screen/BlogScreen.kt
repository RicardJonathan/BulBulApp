package com.example.bulbulapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun BlogScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //box buat button back
            Box(
                modifier = modifier
                    .requiredSize(size = 40.dp)
                    .clip(shape = RoundedCornerShape(112.dp))
                    .background(color = Color(0xffeef1f4))
            ) {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Gray,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 10.dp,
                                y = 10.dp
                            )
                            .requiredSize(size = 20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Blog",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                modifier = Modifier.weight(3f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        // Box search bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(86.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.bgblog2),
                contentDescription = "Blog post image",
                modifier = Modifier
                    .fillMaxSize()
            )
            //Text  Field search bar
            //Search bar masih perlu diperbaiki: search bar masih ada bayangan & line di bawah search bar //
            androidx.compose.material.TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(
                        "Hewan Bahagia, Keluarga pun senang!",
                        color = Color.Gray,
                        fontSize = 14.sp,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        tint = Color.Gray,
                        contentDescription = "Search icon"
                    )
                },
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(1f)
                    .align(Alignment.BottomCenter)
                    .padding(15.dp)
                    .background(Color.White, shape = RoundedCornerShape(30.dp)),
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(3.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp) // Menambahkan padding horizontal
                        .padding(bottom = 650.dp) // Menambahkan padding bottom agar tidak terlalu bawah
                        .align(Alignment.CenterHorizontally)
                ) {
                    val primaryColor = Color(0xFFFF8066)
                    Button(
                        onClick = { TODO() },
                        modifier = Modifier
                            .height(32.dp)
                            .width(90.dp),
                        colors = ButtonDefaults.buttonColors(
                            primaryColor
                        ),
                        shape = RoundedCornerShape(5.dp),
                    ) {
                        Text(
                            text = "Semua",
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                    val secondaryColor = Color(0xF2F2F3F7)
                    Button(
                        onClick = { TODO() },
                        modifier = Modifier
                            .height(32.dp)
                            .width(90.dp),
                        colors = ButtonDefaults.buttonColors(
                            secondaryColor
                        ),
                        shape = RoundedCornerShape(5.dp),
                    ) {
                        Text(
                            text = "Anjing",
                            color = primaryColor,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Justify,
                        )
                    }
                    Button(
                        onClick = { TODO() },
                        modifier = Modifier
                            .height(32.dp)
                            .width(90.dp),
                        colors = ButtonDefaults.buttonColors(
                            secondaryColor
                        ),
                        shape = RoundedCornerShape(5.dp),
                    ) {
                        Text(
                            text = "Kucing",
                            color = primaryColor,
                            fontSize = 10.sp
                        )
                    }
                    Button(
                        onClick = { TODO() },
                        modifier = Modifier
                            .height(32.dp)
                            .width(95.dp),
                        colors = ButtonDefaults.buttonColors(
                            secondaryColor
                        ),
                        shape = RoundedCornerShape(5.dp),
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FilterList, // Menggunakan ikon filter bawaan, boleh diubah
                                    contentDescription = "Filter",
                                    tint = primaryColor,
                                    modifier = Modifier
                                        .height(12.dp)
                                        .width(12.dp)
                                        .align(Alignment.CenterVertically)
                                )
                                Spacer(modifier = Modifier.width(1.dp)) // Spasi antara ikon dan teks
                                Text(
                                    text = "Filter",
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically),
                                    color = primaryColor,
                                    fontSize = 10.sp,
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun BlogScreenPreview() {
    BlogScreen()
}