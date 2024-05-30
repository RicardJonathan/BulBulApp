package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun FotoMyPets(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
        ) {
            Text(
                text = "Foto My Pets",
                color = Color(0xff6d6f77),
                lineHeight = 2.57.em,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .requiredWidth(300.dp)
                    .requiredHeight(28.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(11.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .padding(top = 38.dp, start = 25.dp)
                    .requiredWidth(336.dp)
            ) {
                Property1empty()
                SizeRoundedTypePrimaryStateDefault()
            }
        }
    }
}

@Composable
fun Property1empty(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredSize(70.dp)
            .clip(RoundedCornerShape(5.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.pet1), // Ganti id gambar dengan yang sesuai
            contentDescription = "image",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(5.dp))
        )

        Picture()
    }
}

@Composable
fun Picture(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xffeef1f4))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty),
            contentDescription = "photograph",
            modifier = Modifier
                .align(Alignment.Center)
                .requiredSize(72.dp)
        )
    }
}

@Composable
fun SizeRoundedTypePrimaryStateDefault(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(123.dp)
            .requiredHeight(35.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xffff8066))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Tambahkan Foto",
            color = Color.White,
            lineHeight = 1.83.em,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FotoMyPetsPreview() {
    FotoMyPets(Modifier.fillMaxWidth())
}
