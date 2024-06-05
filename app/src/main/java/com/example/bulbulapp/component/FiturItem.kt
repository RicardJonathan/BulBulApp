package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.navigation.Screen

@Composable
fun FiturScreen(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(25.dp, Alignment.Start),
        modifier = modifier.width(340.dp)
    ) {
        FiturItem(
            imageRes = R.drawable.pets1,
            text = "My Pets",
            textColor = Color(0xffff8066),
            borderColor = Color(0xffffb3a3),
            onClick = { navController.navigate(Screen.CreateMyPtscreen.route) }
        )
        FiturItem(
            imageRes = R.drawable.blog,
            text = "Blog",
            textColor = Color(0xffff8066),
            borderColor = Color(0xffffc0b3),
            onClick = { navController.navigate(Screen.Blog.route) }
        )
        FiturItem(
            imageRes = R.drawable.services,
            text = "Layanan",
            textColor = Color(0xffff8066),
            borderColor = Color(0xffffc0b3),
            onClick = { navController.navigate(Screen.Layanan.route) }
        )
        FiturItem(
            imageRes = R.drawable.product,
            text = "Produk",
            textColor = Color(0xffff8066),
            borderColor = Color(0xffffc0b3),
            onClick = { navController.navigate(Screen.Produk.route) }
        )
    }
}

@Composable
fun FiturItem(
    imageRes: Int,
    text: String,
    textColor: Color,
    borderColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(63.dp)
            .clickable(onClick = onClick)
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            border = androidx.compose.foundation.BorderStroke(0.5.dp, borderColor),
            modifier = Modifier.size(50.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(50.dp)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
        Text(
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(widthDp = 340, heightDp = 74)
@Composable
fun FiturScreenPreview() {
    FiturScreen(navController = rememberNavController())
}
