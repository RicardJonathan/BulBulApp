package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.model.Grooming


@Composable
fun CardGrooming(modifier: Modifier = Modifier, grooming: Grooming, onItemClicked: (Int) -> Unit) {
    androidx.compose.material.Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = modifier
            .clickable { onItemClicked(grooming.id) }
            .size(width = 150.dp, height = 150.dp) // Ubah ukuran kartu sesuai kebutuhan
    ) {
        Column(
            horizontalAlignment = Alignment.Start, // Ubah alignment menjadi Alignment.Start
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = grooming.photo),
                contentDescription = grooming.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(3.dp))
            Text(
                text = grooming.name,
                color = Color(0xff656565),
                lineHeight = 13.89.em,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = grooming.description,
                color = Color(0xff9ba5b7),
                lineHeight = 13.89.em,
                style = TextStyle(
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardGroomingPreview() {
    val dummyGrooming = DummyData.listGrooming.first() // Ambil item pertama dari listLayanan sebagai contoh
    CardGrooming(grooming = dummyGrooming, onItemClicked = {})
}
