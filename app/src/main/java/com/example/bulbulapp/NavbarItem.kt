package com.example.bulbulapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavbarItem(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .requiredWidth(width = 359.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .background(color = Color.White)
    ) {
        NavBarItemContent(
            iconId = R.drawable.home,
            text = "Beranda",
            textColor = Color(0xffff8066),
            lineId = R.drawable.home,
            lineColor = Color(0xffff8066)
        )
        NavBarItemContent(
            iconId = R.drawable.navbarpet,
            text = "My Pets",
            textColor = Color(0xff6d6f77),
            lineId = R.drawable.navbarpet
        )
        NavBarItemContent(
            iconId = R.drawable.blog,
            text = "Blog",
            textColor = Color(0xff6d6f77),
            lineId = R.drawable.blog
        )
        NavBarItemContent(
            iconId = R.drawable.services,
            text = "Produk",
            textColor = Color(0xff6d6f77),
            lineId = R.drawable.services
        )
        NavBarItemContent(
            iconId = R.drawable.productnav,
            text = "Layanan",
            textColor = Color(0xff6d6f77),
            lineId = R.drawable.productnav
        )
    }
}

@Composable
fun NavBarItemContent(
    iconId: Int,
    text: String,
    textColor: Color,
    lineId: Int? = null,
    lineColor: Color? = null
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .requiredWidth(width = 58.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "Navbar icon"
        )
        Text(
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(fontSize = 10.sp)
        )
        lineId?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Line",
                modifier = Modifier
                    .requiredWidth(width = 43.dp)
                    .border(border = BorderStroke(2.dp, lineColor!!))
            )
        }
    }
}
@Preview(widthDp = 360, heightDp = 279)
@Composable
fun NavbarItemPreview() {
    NavbarItem(Modifier)
}