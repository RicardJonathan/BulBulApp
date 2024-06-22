package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun KondisiBadanItem(modifier: Modifier = Modifier) {
    var selected by remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier
            .requiredWidth(324.dp)
            .requiredHeight(213.dp)
            .padding(horizontal = 50.dp)

    ) {
        Box(
            modifier = Modifier
                .requiredWidth(326.dp)
                .requiredHeight(28.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                modifier = Modifier.requiredWidth(326.dp)
            ) {
                Text(
                    text = "Kondisi Badan",
                    color = Color(0xff545f71),
                    lineHeight = 2.57.em,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .requiredWidth(337.dp)
                        .requiredHeight(28.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.iconkondisi),
                contentDescription = "exclamation-circle",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 306.dp, y = 4.dp)
                    .requiredSize(20.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 48.dp)
                .requiredWidth(331.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                modifier = Modifier.requiredWidth(330.dp)
            ) {
                BodyConditionItem(text = "Too Thin", imageResId = R.drawable.bc_cat_thin)
                BodyConditionItem(text = "Thin", imageResId = R.drawable.bc_cat_toothin)
                BodyConditionItem(text = "Normal", imageResId = R.drawable.bc_catnormal)
                BodyConditionItem(text = "Overweight", imageResId = R.drawable.bc_cat_overweight)
                BodyConditionItem(text = "Obese", imageResId = R.drawable.bc_cat_obese)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.requiredWidth(322.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.requiredWidth(333.dp)
                ) {
                    repeat(9) { index ->
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.requiredSize(20.dp)
                        ) {
                            RadioButton(
                                selected = selected == index,
                                onClick = { selected = index },
                                modifier = Modifier.wrapContentHeight()
                            )
                            Text(
                                text = "${index + 1}",
                                color = Color(0xff545f71),
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier
                                    .requiredSize(40.dp)
                                    .offset(y = (15.dp)) // Adjust the offset value as needed
                                    .wrapContentHeight(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BodyConditionItem(text: String, imageResId: Int) {
    Box(
        modifier = Modifier
            .requiredWidth(60.dp)
            .requiredHeight(70.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Image placeholder",
                modifier = Modifier
                    .requiredSize(50.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .border(0.5.dp, Color(0xffeaebf0), RoundedCornerShape(5.dp))
            )
            Text(
                text = text,
                color = Color(0xff545f71),
                textAlign = TextAlign.Center,
                lineHeight = 3.6.em,
                style = TextStyle(fontSize = 10.sp),
                modifier = Modifier
                    .requiredWidth(60.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
    }
}
@Preview(widthDp = 350, heightDp = 213)
@Composable
private fun KondisiBadanItemPreview() {
    KondisiBadanItem()
}
