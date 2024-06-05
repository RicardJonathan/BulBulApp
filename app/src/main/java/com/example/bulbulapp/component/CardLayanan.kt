package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun CardLayanan(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(150.dp)
            .height(230.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .height(110.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.imagelayaan1),
                    contentDescription = "image 24",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Puppy Planet...",
                color = Color(0xff545f71),
                lineHeight = 11.36.em,
                style = TextStyle(
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = "Menawarkan Jasa Grooming dan Penitipan Hewan yang aman",
                color = Color(0xff9ba5b7),
                lineHeight = 13.89.em,
                style = TextStyle(
                    fontSize = 3.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .requiredWidth(width = 58.dp)
                    .requiredHeight(height = 15.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(color = Color(0xffffa694))
                    .padding(all = 2.dp)
            ) {
                Text(
                    text = "Grooming",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.9.em,
                    style = TextStyle(
                        fontSize = 10.sp
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(width = 142.dp)
                .requiredHeight(height = 26.dp)
                .clip(shape = RoundedCornerShape(24.dp))
                .background(color = Color(0xffff8066))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Lihat Layanan",
                color = Color.White,
                lineHeight = 1.58.em,
                style = TextStyle(
                    fontSize = 12.sp
                ),
                modifier = Modifier
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.bintang),
            contentDescription = "Vector",
            modifier = Modifier.size(4.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "4,8",
            color = Color(0xff545f71),
            lineHeight = 9.62.em,
            style = TextStyle(
                fontSize = 4.sp
            )
        )
    }
}

@Composable
fun SizePillTypePrimaryStateDefault(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(142.dp)
            .height(26.dp)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color(0xffff8066))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Lihat Layanan",
            color = Color.White,
            lineHeight = 1.58.em,
            style = TextStyle(
                fontSize = 12.sp
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CardLayananPreview() {
    CardLayanan(Modifier)
}