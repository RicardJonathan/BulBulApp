package com.example.bulbulapp.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R
import com.example.bulbulapp.ui.theme.BulBulAppTheme

class DetailPetScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BulBulAppTheme {
                PetProfileScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BulBul") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_menu_revert),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                PetProfileCard()
                Spacer(modifier = Modifier.height(16.dp))
                PetInfoSection()
                Spacer(modifier = Modifier.height(16.dp))
                PetWeightGraph()
                Spacer(modifier = Modifier.height(16.dp))
                PetActivityList()
                Spacer(modifier = Modifier.height(16.dp))
                ProductRecommendations()
            }
        }
    )
}

@Composable
fun PetProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0E0)) // Adjust color as needed
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bulbulpet1), // Replace with your actual image resource
                contentDescription = "Pet Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("BulBul", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Umur: 1 tahun", fontSize = 16.sp, color = Color.Gray)
                Text("Berat: 3 kg", fontSize = 16.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { /* Handle edit click */ }) {
                Text("Edit")
            }
        }
    }
}

@Composable
fun PetInfoSection() {
    Column {
        Text("Info My Pets", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoCard(
                iconRes = R.drawable.cat_medium, // Replace with your actual icon resource
                title = "Body",
                subtitle = "Medium"
            )
            InfoCard(
                iconRes = R.drawable.cat_activity_level_high_activity, // Replace with your actual icon resource
                title = "Tingkat Aktivitas",
                subtitle = "High Activity"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Kalori Harian",
                subtitle = "401 Kalori"
            )
            Text(
                text = "Hidangan",
                subtitle = "52 Gram Per Hari"
            )
        }
    }
}

private fun RowScope.Text(text: String, subtitle: String) {
    TODO("Not yet implemented")
}

@Composable
fun InfoCard(iconRes: Int, title: String, subtitle: String) {
    Card(
        modifier = Modifier
//            .weight(1f)
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Composable
fun PetWeightGraph() {
    Column {
        Text("Berat Badan", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        // Use your preferred chart/graph library here, this is a placeholder
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFFFE0E0), RoundedCornerShape(8.dp))
        ) {
            // Placeholder content for the graph
            Text("Graph Placeholder", modifier = Modifier.align(Alignment.Center))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Handle upload action */ }) {
            Text("Upload Laporan")
        }
    }
}

@Composable
fun PetActivityList() {
    Column {
        Text("Aktivitas BulBul", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        ActivityCard(
            iconRes = R.drawable.bell1, // Replace with your actual icon resource
            title = "Vaksinasi",
            time = "Rabu - 05 May 2024 09:00 WIB"
        )
        ActivityCard(
            iconRes = R.drawable.bell1, // Replace with your actual icon resource
            title = "Grooming",
            time = "Jumat - 07 May 2024 15:00 WIB"
        )
        ActivityCard(
            iconRes = R.drawable.bell1, // Replace with your actual icon resource
            title = "Makan",
            time = "Sabtu - 09 May 2024 08:00 WIB"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { /* Handle add reminder */ }) {
            Text("Tambah Pengingat")
        }
    }
}

@Composable
fun ActivityCard(iconRes: Int, title: String, time: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0E0)), // Adjust color as needed
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(time, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun ProductRecommendations() {
    Column {
        Text("Rekomendasi Produk", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductCard(
                imageRes = R.drawable.meo_ocean_fish, // Replace with your actual image resource
                title = "Me-O Kitten Ocean Fish",
                description = "400g"
            )
            ProductCard(
                imageRes = R.drawable.chummy_dog, // Replace with your actual image resource
                title = "Chunky Pet Dog",
                description = "375g"
            )
        }
    }
}

@Composable
fun ProductCard(imageRes: Int, title: String, description: String) {
    Card(
        modifier = Modifier
//            .weight(1f)
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(description, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetProfileScreenPreview() {
    BulBulAppTheme {
        PetProfileScreen()
    }
}
