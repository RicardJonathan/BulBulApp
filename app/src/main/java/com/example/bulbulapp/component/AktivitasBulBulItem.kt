package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

data class AktivitasItem(val imageBell: Int)

@Composable
fun AktivitasBulBulItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(361.dp)
            .height(200.dp)
    ) {
        val gridData = listOf(
            AktivitasItem(R.drawable.bell_reminder),
            AktivitasItem(R.drawable.bell_reminder)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 19.dp, y = 50.dp)
                .width(324.dp)
                .height(150.dp)
        ) {
            items(gridData) { item ->
                AktivitasCard(imageBell = item.imageBell)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(170.dp),
            modifier = Modifier
                .width(361.dp)
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Aktivitas BulBul",
                color = Color(0xff6d6f77),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .width(127.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = R.drawable.chevrondown),
                contentDescription = "chevron-down",
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}

@Composable
fun AktivitasCard(modifier: Modifier = Modifier, imageBell: Int) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageBell),
                contentDescription = "Bell Icon",
                modifier = Modifier
                    .size(40.dp)
                    .graphicsLayer(rotationZ = 25f)
            )
            AktivitasText()
        }
    }
}

@Composable
fun AktivitasText(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier.width(194.dp)
    ) {
        Text(
            text = "Vaksinasi",
            color = Color(0xffff8066),
            lineHeight = 1.58.em,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier
                .width(96.dp)
                .height(12.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Text(
            text = "BulBul - 02 May 2024 10.00 WIB",
            color = Color(0xffff8066),
            lineHeight = 1.2.em,
            style = TextStyle(fontSize = 10.sp),
            modifier = Modifier
                .width(211.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
    }
}

@Preview(widthDp = 361, heightDp = 200)
@Composable
private fun AktivitasBulBulItemPreview() {
    AktivitasBulBulItem()
}
