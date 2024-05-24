package com.example.bulbulapp.profile

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun HapusAkunOverlay(
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(250.dp)
            .background(Color.White)
            .padding(20.dp)
            .clip(RoundedCornerShape(8.dp))
            .shadow(elevation = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_overlay2),
                contentDescription = "image overlay",
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Apakah Anda yakin Hapus Akun?",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val primaryColor = Color(0xFFFF8066)
                Button(
                    onClick = onCancel,
                    modifier = Modifier
                        .height(40.dp)
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(primaryColor
                    ),
                    shape = RoundedCornerShape(5.dp),
                ){
                    Text(
                        text = "Batal",
                        color = Color.White)
                }
                val secondaryColor = Color(0xF2F2F3F7)
                Button(
                    onClick = onCancel,
                    modifier = Modifier
                        .height(40.dp)
                        .width(120.dp),
                    colors = ButtonDefaults.buttonColors(secondaryColor
                    ),
                    shape = RoundedCornerShape(5.dp),
                ){
                    Text(
                        text = "Ya, keluar",
                        color = Color.DarkGray,
                        fontSize = 14.sp)
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewHapusAkunOverlay() {
    HapusAkunOverlay(
        onConfirm = {},
        onCancel = {}
    )
}