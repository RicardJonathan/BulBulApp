package com.example.bulbulapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BerandaScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 200.dp) // Lebih besar agar gambar tidak sejajar dengan ikon
            .padding(horizontal = 10.dp)
            .background(Color.White) // Tambahkan latar belakang putih
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            InputChip(
                label = {
                    Text(
                        text = "Berikan yang terbaik untuk hewanmu",
                        color = Color(0xff9ba5b7),
                        lineHeight = 1.58.sp,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search",
                        modifier = Modifier
                            .requiredSize(size = 30.dp) // Samakan ukuran dengan ikon settings dan bell
                    )
                },
                shape = RoundedCornerShape(6.dp),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.White
                ),
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.width(12.dp)) // Spacer agar ada jarak antara bagian atas dengan gambar
            Icon(
                painter = painterResource(id = R.drawable.settings), // Ubah "settings" dengan nama file gambar ikon settings yang sesuai
                contentDescription = "Settings Icon",
                modifier = Modifier.size(10.dp) // Menetapkan ukuran ikon
            )
            Icon(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = "Bell Icon",
                modifier = Modifier.size(10.dp) // Menetapkan ukuran ikon
            )
        }
        Spacer(modifier = Modifier.height(12.dp)) // Spacer agar ada jarak antara gambar dengan bagian bawah
        Image(
            painter = painterResource(id = R.drawable.user), // Adjust image resource
            contentDescription = "Gambar WhatsApp",
            modifier = Modifier
                .size(91.dp)
                .clip(CircleShape) // Mengubah gambar menjadi bulat
                .align(Alignment.End), // Pindahkan gambar ke kanan
            contentScale = ContentScale.Crop
        )
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun BerandaScreenPreview() {
    BerandaScreen()
}
