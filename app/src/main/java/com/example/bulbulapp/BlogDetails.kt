package com.example.bulbulapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.navigation.Screen

@Composable
fun BlogDetails(navController: NavController, modifier: Modifier = Modifier) {
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
                    onClick = {navController.navigate(Screen.Blog.route)}
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
                text = "Detail Blog",
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
        // Row for the AssistChips
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

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.RemoveRedEye,
                contentDescription = "Read time",
                tint = Color.Gray,
                modifier = Modifier.size(16.dp) // Adjust the size as needed
            )
            Text(
                text = "2 menit",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Cara Mengetahui Berat Badan Ideal untuk Kucing",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Rekomendasi",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.weight(1f))
            ClickableText(
                text = AnnotatedString("Lihat Lainnya"),
                onClick = {},
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFFFF8066),
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        //content blog belom
    }
}

@Preview(showBackground = true)
@Composable
fun BlogDetailsPreview() {
    val navController = rememberNavController()
    BlogDetails(navController = navController)
}
