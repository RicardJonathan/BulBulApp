package com.example.bulbulapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

data class BeratdanUmurItem(val textLabel: String, val textText: String, val iconChartpie: Int)

@Composable
fun UkuranHewan(modifier: Modifier = Modifier) {
    val gridData = listOf(
        BeratdanUmurItem("Berat", "0 kg", R.drawable.chartpie),
        BeratdanUmurItem("Umur", "0 th", R.drawable.calendar)
    )
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        content = {
            items(gridData) { item ->
                TypePlaceholder(
                    textLabel = item.textLabel,
                    textText = item.textText,
                    iconChartpie = item.iconChartpie
                )
            }
        },
        modifier = modifier
            .requiredWidth(325.dp)
            .requiredHeight(75.dp)
    )
}

@Composable
fun TypePlaceholder(
    textLabel: String,
    textText: String,
    iconChartpie: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp, Alignment.Bottom),
        modifier = modifier
            .requiredWidth(158.dp)
    ) {
        Text(
            text = textLabel,
            color = Color(0xff6d6f77),
            lineHeight = 1.36.em,
            style = TextStyle(fontSize = 14.sp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(48.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .border(BorderStroke(1.dp, Color(0xff6d6f77)), RoundedCornerShape(6.dp))
                .padding(12.dp)
        ) {
            Text(
                text = textText,
                color = Color(0xff9ba5b7),
                lineHeight = 1.83.em,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = iconChartpie),
                contentDescription = "chart-pie",
                modifier = Modifier.requiredSize(24.dp), // Adjust the size as needed
                tint = Color(0xFFFF8066) // Set the tint color to #FF8066
            )
        }
    }
}

@Preview(widthDp = 325, heightDp = 75)
@Composable
private fun UkuranHewanPreview() {
    UkuranHewan()
}
