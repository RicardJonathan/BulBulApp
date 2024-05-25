package com.example.bulbulapp.screen


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R


@Composable
fun GantiPasswordSuksesScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 20.dp, vertical = 80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ilustrasivervikasiberhasil),
                contentDescription = "Ilustrasi Verifikasi Berhasil",
                modifier = Modifier
                    .width(325.dp)
                    .height(370.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Password Berhasil diubah !",
                color = Color(0xffff8066),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold, // Membuat teks menjadi bold
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Button(
                onClick = { /* Handle login action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(60.dp), // Perbesar tinggi tombol
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF8066) // Warna dalam format hex
                ),
                shape = RoundedCornerShape(8.dp) // Menambahkan shape dengan sudut melengkung lebih besar
            ) {
                Text(
                    text = "Masuk Sekarang",
                    color = Color.White,
                    fontSize = 18.sp, // Perbesar ukuran font
                    fontWeight = FontWeight.Bold // Membuat teks menjadi bold
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(widthDp = 360, heightDp = 812)
@Composable
private fun GantiPasswordScreenPreview() {
    GantiPasswordSuksesScreen()
}