package com.example.bulbulapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
fun InputTanggalDanBeratItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 357.dp)
            .requiredHeight(height = 213.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            modifier = Modifier
                .requiredWidth(width = 357.dp)
                .fillMaxHeight()
                .padding(horizontal = 10.dp)
        ) {
            EmptyProperty1("DD/MM/YY")
            EmptyProperty2("0 kg")
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 206.dp, y = 178.dp)
                .requiredWidth(width = 140.dp)
                .requiredHeight(height = 35.dp)
        ) {
            SizeRegularTypePrimaryStateDefault()
        }
    }
}

@Composable
fun EmptyProperty1(tanggal: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 336.dp)
            .requiredHeight(height = 74.dp)
    ) {
        TypePlaceholder(tanggal, R.drawable.calendar, 24, iconColor = Color(0xffff8066)) // Ubah warna ikon di sini
    }
}

@Composable
fun EmptyProperty2(berat: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 336.dp)
            .requiredHeight(height = 74.dp)
    ) {
        TypePlaceholder(berat, R.drawable.chartpie, 24, iconColor = Color(0xffff8066)) // Ubah warna ikon di sini
    }
}

@Composable
fun TypePlaceholder(
    value: String,
    iconId: Int,
    iconSize: Int,
    iconColor: Color, // Tambahkan parameter warna ikon
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp, Alignment.Bottom),
        modifier = modifier
            .requiredWidth(width = 337.dp)
    ) {
        Text(
            text = "Berat",
            color = Color(0xff6d6f77),
            lineHeight = 1.36.em,
            style = TextStyle(
                fontSize = 14.sp
            )
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 48.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                .background(color = Color.White)
                .border(border = BorderStroke(1.dp, Color(0xff9ba5b7)),
                    shape = RoundedCornerShape(6.dp))
                .padding(all = 12.dp)
        ) {
            Text(
                text = value,
                color = Color(0xff9ba5b7),
                lineHeight = 1.57.em,
                style = TextStyle(
                    fontSize = 14.sp
                ),
                modifier = Modifier.weight(weight = 1f)
            )
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "chart-pie",
                tint = iconColor, // Gunakan parameter warna ikon
                modifier = Modifier.size(iconSize.dp)
            )
        }
    }
}

@Composable
fun SizeRegularTypePrimaryStateDefault(modifier: Modifier = Modifier) {
    Button(
        onClick = { /* TODO: Handle button click */ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffff8066)),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .requiredWidth(width = 139.dp)
            .requiredHeight(height = 35.dp)
    ) {
        Text(
            text = "Tambahkan",
            color = Color.White,
            lineHeight = 1.83.em,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Preview(widthDp = 357, heightDp = 213)
@Composable
private fun InputTanggalDanBeratItemPreview() {
    InputTanggalDanBeratItem(Modifier)
}