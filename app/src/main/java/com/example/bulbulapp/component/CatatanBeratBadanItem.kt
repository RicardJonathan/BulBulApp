package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun CatatanBeratBadanItem(modifier: Modifier = Modifier, imagePainter: Painter) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(354.dp)
            .requiredHeight(80.dp)
            .padding(start = 10.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(335.dp)
                .requiredHeight(70.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xffff8066))
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Berat Badan",
                        color = Color.White,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center)
                    )
                    Text(
                        text = "4 kg - 02 May 2024",
                        color = Color.White,
                        style = TextStyle(fontSize = 10.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Spacer to push the content to the right
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Image(
                        painter = imagePainter,
                        contentDescription = "image",
                        modifier = Modifier
                            .requiredWidth(20.dp) // Adjust width to make the image smaller
                            .requiredHeight(20.dp) // Adjust height to make the image smaller
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(3.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Berat Naik",
                            color = Color.White,
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.wrapContentSize(align = Alignment.CenterEnd)
                        )
                        Text(
                            text = "1 kg",
                            color = Color.White,
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.wrapContentSize(align = Alignment.CenterEnd)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CatatanBeratBadanItemPreview() {
    val imagePainter = painterResource(id = R.drawable.polygon1)
    CatatanBeratBadanItem(imagePainter = imagePainter)
}
