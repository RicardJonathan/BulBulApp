package com.example.bulbulapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BlogDetails(modifier: Modifier = Modifier) {
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
            Box(
                modifier = Modifier
                    .requiredSize(size = 40.dp)
                    .clip(shape = RoundedCornerShape(112.dp))
                    .background(color = Color(0xffeef1f4)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Gray,
                        modifier = Modifier
                            .requiredSize(size = 20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Blog Details",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                modifier = Modifier.weight(2f),
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.blogdetails), // Replace with your image resource
            contentDescription = "Blog Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between the chips
        ) {
            AssistChip(
                onClick = {},
                label = { Text("Edukasi") },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color(0xFFFFB3A3),
                    labelColor = Color.White
                )
            )
            AssistChip(
                onClick = {},
                label = { Text("Kucing") },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color(0xFFFFB3A3),
                    labelColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Cara Mengetahui Berat Badan Ideal untuk Kucing",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tahukah kamu, kucing juga perlu mendapatkan berat badan ideal? Masalahnya pemilik hewan peliharaan kerap memanjakan kucingnya dengan memberikan makanan yang berlebihan. Sebagian besar kucing rumahan dewasa biasanya memiliki berat sekitar 3,6-4,5 kilogram, meskipun ini dapat bervariasi berdasarkan ras, umur, dan jenis kelamin. Seekor kucing Siam beratnya hanya 2,2 kilogram, sedangkan Maine Coon bisa beratnya 11 kilogram dan ini tergolong sehat. Penambahan berat badan kucing biasanya tergantung pada jenis dan jumlah makanan yang diberikan, serta kebosanan si kucing. Kalau kucing merasa bosan, kucing akan berpikir untuk makan.",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Rekomendasi",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
        //ini belom bisa
        Spacer(modifier = Modifier.height(8.dp))
        ClickableText(
            text = AnnotatedString("Lihat Lainnya"),
            onClick = {},
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 15.sp,
                color = Color(0xFFFFB3A3),
                fontWeight = FontWeight.Bold
            )
        )
        //content blog belom
    }
}

@Preview(showBackground = true)
@Composable
fun BlogDetailsPreview() {
    BlogDetails()
}
