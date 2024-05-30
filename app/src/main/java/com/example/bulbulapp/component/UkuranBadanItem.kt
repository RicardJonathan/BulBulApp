package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
fun UkuranBadanItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(341.dp)
            .requiredHeight(158.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 0.dp, y = 42.dp)
        ) {
            var selectedOption by remember { mutableStateOf("Medium") } // Default selected option
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                modifier = Modifier.requiredWidth(338.dp)
            ) {
                UkuranBadanItemOption(
                    text = "Toy",
                    imageResId = R.drawable.cattoy,
                    isSelected = selectedOption == "Toy",
                    onClick = { selectedOption = "Toy" }
                )
                UkuranBadanItemOption(
                    text = "Small",
                    imageResId = R.drawable.cat_small,
                    isSelected = selectedOption == "Small",
                    onClick = { selectedOption = "Small" }
                )
                UkuranBadanItemOption(
                    text = "Medium",
                    imageResId = R.drawable.catmedium,
                    isSelected = selectedOption == "Medium",
                    onClick = { selectedOption = "Medium" }
                )
                UkuranBadanItemOption(
                    text = "Large",
                    imageResId = R.drawable.catbig,
                    isSelected = selectedOption == "Large",
                    onClick = { selectedOption = "Large" }
                )
                UkuranBadanItemOption(
                    text = "Giant",
                    imageResId = R.drawable.cat_giant,
                    isSelected = selectedOption == "Giant",
                    onClick = { selectedOption = "Giant" }
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 1.dp, y = 2.dp)
                .requiredWidth(337.dp)
                .requiredHeight(20.dp)
        ) {
            Text(
                text = "Ukuran Badan",
                color = Color(0xff6d6f77),
                lineHeight = 2.57.em,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .requiredWidth(337.dp)
                    .requiredHeight(20.dp)
            )
        }
    }
}

@Composable
fun UkuranBadanItemOption(
    text: String,
    imageResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .requiredWidth(60.dp)
            .requiredHeight(70.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Image placeholder",
                modifier = Modifier
                    .requiredWidth(60.dp)
                    .requiredHeight(45.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Text(
                text = text,
                color = Color(0xff6d6f77),
                textAlign = TextAlign.Center,
                lineHeight = 3.6.em,
                style = TextStyle(
                    fontSize = 10.sp
                ),
                modifier = Modifier
                    .offset(y = 3.dp)
                    .requiredWidth(40.dp) // Increased width to ensure text is not cut off
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
            RadioButton(
                selected = isSelected,
                onClick = onClick,
                modifier = Modifier.offset(y = 15.dp)
            )
        }
    }
}

@Preview(widthDp = 341, heightDp = 158)
@Composable
private fun UkuranBadanItemPreview() {
    UkuranBadanItem(Modifier)
}
