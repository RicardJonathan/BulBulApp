package com.example.bulbulapp.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.ui.theme.BulBulAppTheme

class PengaturanNotifikasiScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BulBulAppTheme {
                NotificationSettingsScreen()
            }
        }
    }
}

@Composable
fun NotificationSettingsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { androidx.compose.material.Text("Pengaturan Notifikasi") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                elevation = 0.dp
            )
        },
        content = { paddingValues ->
            NotificationSettingsContent(Modifier.padding(paddingValues))
        }
    )
}
@Composable
fun NotificationSettingsContent(padding: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NotificationItem("Reminder", "Aktifkan pemberitahuan reminder !")
        NotificationItem("Blog", "Aktifkan pemberitahuan blog terbaru !")
        NotificationItem("Rekomendasi Produk", "Aktifkan Rekomendasi Produk My Pets !")
        NotificationItem("Rekomendasi Layanan", "Aktifkan Rekomendasi Layanan My Pets !")
        NotificationItem("Update Aplikasi BulBul", "Pemberitahuan Update Aplikasi BulBul !")
    }
}

@Composable
fun NotificationItem(title: String, description: String) {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = title, fontSize = 20.sp)
            Text(text = description, fontSize = 16.sp, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
        }
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationSettingsScreenPreview() {
    BulBulAppTheme {
        NotificationSettingsScreen()
    }
}
