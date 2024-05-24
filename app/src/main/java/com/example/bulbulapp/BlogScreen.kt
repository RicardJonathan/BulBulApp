package com.example.bulbulapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
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

import com.example.bulbulapp.ui.theme.BulBulAppTheme

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
                IconButton(onClick ={}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 10.dp,
                                y = 10.dp
                            )
                            .requiredSize(size = 20.dp))
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
                painter = painterResource(id = R.drawable.bgblog),
                contentDescription = "Blog post image",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 5.dp, topEnd = 16.dp))
            )
            //Text  Field search bar
            androidx.compose.material.TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Hewan Bahagia, Keluarga pun senang!", fontSize = 14.sp) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search icon"
                    )
                },
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(1f)
                    .align(Alignment.BottomCenter)
                    .padding(15.dp)
                    .background(Color.White, shape = RoundedCornerShape(10.dp)),


                )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun BlogScreenPreview() {
    BlogScreen()
}