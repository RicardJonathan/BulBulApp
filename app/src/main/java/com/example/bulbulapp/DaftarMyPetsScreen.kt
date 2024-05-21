package com.example.bulbulapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun DaftarMyPetsScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(360.dp)
            .requiredHeight(812.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.petsnew),
                contentDescription = "Ilustrasi (my pets-default) 1",
                modifier = Modifier
                    .padding(start = 52.dp, top = 99.dp)
                    .width(270.dp)
                    .height(480.dp)
            )
            Text(
                text = "Halo, Pawrents!\nAyo, daftarkan Pets kamu",
                color = Color(0xffff8066),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .padding(start = 32.dp, top = 141.dp)
                    .width(296.dp)
                    .height(67.dp)
            )
            SizeRoundedTypePrimaryStateDefault(
                modifier = Modifier
                    .padding(start = 88.dp, top = 500.5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 10.dp, top = 44.dp)
                    .width(360.dp)
                    .height(55.dp)
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(112.dp))
                        .background(Color(0xffeef1f4)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.petsnew),
                        contentDescription = "arrow-left",
                        modifier = Modifier.size(20.dp)
                    )
                }
                Selector()
            }
        }
    }
}

@Composable
fun SizeRoundedTypePrimaryStateDefault(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(178.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xffff8066))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Daftar My Pets",
            color = Color.White,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

data class SelectorItem(val textMyPets: String)

@Composable
fun Selector(modifier: Modifier = Modifier) {
    val gridData = listOf(SelectorItem("My Pets"), SelectorItem("My Pets"))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .height(30.dp)
    ) {
        items(gridData.size) { index ->
            val textMyPets = gridData[index].textMyPets
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xffff9985))
                    .padding(horizontal = 30.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = textMyPets,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.38.em,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MyPetsScreenPreview() {
    DaftarMyPetsScreen()
}
