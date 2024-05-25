package com.example.bulbulapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.model.MyPets

@Composable
fun MyPetsItem(modifier: Modifier = Modifier, myPetsList: List<MyPets>) {
    Box(
        modifier = modifier
            .background(Color.White)
            .width(325.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(88.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pilih My Pets",
                    color = Color(0xff6d6f77),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
                Text(
                    text = "Lihat Semua",
                    color = Color(0xffff8066),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .width(100.dp)
                        .height(28.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }

            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(70.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    myPetsList.forEach { myPet ->
                        Image(
                            painter = painterResource(id = myPet.photo),
                            contentDescription = "Image placeholder",
                            modifier = Modifier
                                .size(70.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .border(BorderStroke(1.dp, Color(0xffd0d2dd)), RoundedCornerShape(8.dp))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ImagePlaceholder(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color(0xffd0d2dd)),
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
    ) {
        Box(
            modifier = Modifier
                .requiredSize(size = 70.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pet1),
                contentDescription = "Icons/image",
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun TypeIcon2(modifier: Modifier = Modifier) {
    // Implementation of TypeIcon2, assumed to be an icon or some content
}

@Preview(widthDp = 325, heightDp = 108)
@Composable
private fun MyPetsItemPreview() {
    MyPetsItem(myPetsList = DummyData.listMyPets)
}
