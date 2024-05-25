package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
fun GrafikBeratBadanItem(
    modifier: Modifier = Modifier,
    barHeights: List<Float> = listOf(0.5f, 0.4f, 0.6f, 0.3f, 0.7f, 0.2f) // Contoh tinggi bar chart relatif
) {
    Box(
        modifier = modifier
            .width(360.dp)
            .height(279.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = modifier
                .align(Alignment.TopStart)
                .offset(y = 39.dp)
                .width(359.dp)
                .height(240.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                modifier = modifier
                    .width(359.dp)
                    .height(240.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Box(
                    modifier = modifier
                        .width(334.dp)
                        .height(226.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                        modifier = modifier
                            .align(Alignment.TopStart)
                            .offset(y = 12.dp)
                            .width(335.dp)
                    ) {
                        val weights = listOf("10 kg", "8 kg", "6 kg", "4 kg", "2 kg", "0 kg")
                        weights.forEachIndexed { index, weight ->
                            Box(
                                modifier = modifier
                                    .width(335.dp)
                                    .height(19.dp)
                            ) {
                                Divider(
                                    color = Color(0xffeef1f4),
                                    modifier = modifier
                                        .align(Alignment.TopStart)
                                        .offset(x = 37.92.dp, y = 9.dp)
                                        .width(297.dp)
                                        .rotate(180f)
                                )
                                Text(
                                    text = weight,
                                    color = Color(0xff9ba5b7),
                                    lineHeight = 1.58.em,
                                    style = TextStyle(fontSize = 12.sp),
                                    modifier = modifier
                                        .width(32.dp)
                                        .height((barHeights[index] * 150).dp) // Tinggi bar chart dinamis
                                        .wrapContentHeight(align = Alignment.CenterVertically)
                                )
                            }
                        }
                    }
                }

                // Additional Text below the TextField
                Text(
                    text = "Additional Text",
                    color = Color(0xff6d6f77),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = modifier.padding(vertical = 8.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp), // Adjust spacing here
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .align(Alignment.TopStart)
                    .offset(x = 52.dp, y = 129.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chart),
                    contentDescription = "Bar Chart",
                    modifier = modifier
                        .width(88.dp)
                        .height(87.dp)
                )
                // Additional Images for the new bar charts
                Image(
                    painter = painterResource(id = R.drawable.grafik2),
                    contentDescription = "Bar Chart",
                    modifier = modifier
                        .width(88.dp)
                        .height(87.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.grafik3),
                    contentDescription = "Bar Chart",
                    modifier = modifier
                        .width(88.dp)
                        .height(87.dp)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(80.dp, Alignment.End), // Align to end here
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .align(Alignment.TopEnd) // Align to top end
                .offset(x = 10.dp)
                .width(324.dp)
        ) {
            // Additional Text "Lihat Laporan" at top end

            Text(
                text = "Berat Badan",
                color = Color(0xff6d6f77),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = modifier
                    .width(136.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .offset(x = (-50).dp) // Adjust offset to move left
            )
            Text(
                text = "Lihat Laporan",
                color = Color(0xffff8066),
                lineHeight = 1.83.em,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = modifier
                    .padding(top = 8.dp) // Add padding if needed
                    .offset(x = (-20).dp) // Adjust offset to move left
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 279)
@Composable
private fun GrafikBeratBadanItemPreview() {
    GrafikBeratBadanItem(Modifier)
}
