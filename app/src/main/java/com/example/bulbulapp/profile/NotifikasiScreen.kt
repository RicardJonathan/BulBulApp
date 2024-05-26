package com.example.bulbulapp.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

data class Notification(val iconRes: Int, val title: String, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(notifications: List<Notification>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifikasi") },
                navigationIcon = {
                    androidx.compose.material.IconButton(onClick = { /* Handle back navigation */ }) {
                        androidx.compose.material.Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                modifier = Modifier.background(Color.White)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
        ) {
            notifications.forEach { notification ->
                NotificationItem(notification)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
//                .size(40.dp)
//                .background(Color(0xFFFF8066), shape = CircleShape),
//            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = notification.iconRes),
                contentDescription = notification.title,
                modifier = Modifier.size(50.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = notification.title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
            Text(text = notification.description, fontSize = 12.sp, color = Color.DarkGray)
        }
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(onClick = { /* Handle back navigation */ }) {
            androidx.compose.material.Icon(
                Icons.Filled.Dangerous,
                tint = Color.Gray,
                contentDescription = "Delete",)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    val notifications = remember {
        listOf(
            Notification(R.drawable.notifikasi_update, "Reminder", "Waktunya Vaksin My Pets!"),
            Notification(R.drawable.notifikasi_blog, "Blog", "Tips pentingnya steriliasi untuk anjing & kucingmu dalam blog terbaru!"),
            Notification(R.drawable.notifikasi_product, "Rekomendasi Produk", "Whiskas adult 80 Gram Rasa Crab sudah tersedia!"),
            Notification(R.drawable.notifikasi_product, "Rekomendasi Layanan", "Layanan Terdekat: Nakama PetCare Siap Melayanimu!"),
            Notification(R.drawable.notifikasi_update, "Update", "Aplikasi BulBul Versi 12 Tersedia Install Sekarang!")
        )
    }
    NotificationScreen(notifications = notifications)
}
