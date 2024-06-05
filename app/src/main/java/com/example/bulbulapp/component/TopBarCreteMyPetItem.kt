package com.example.bulbulapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.navigation.Screen

@Composable
fun TopBarCreteMyPetItem(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(30.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .width(390.dp)
            .height(55.dp)
            .background(color = Color.White)
            .padding(horizontal = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(shape = RoundedCornerShape(112.dp))
                .background(color = Color(0xffeef1f4))
                .clickable {
                    // Handle the click event here
                    println("Icon clicked")
                }
        ) {
            IconButton(
                onClick = { navController.navigate(Screen.Home.route) },
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back), // Assuming R.drawable.back is your icon resource
                    contentDescription = "arrow-left",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(20.dp)
                )
            }
        }
        Selector()
    }
}
data class SelectorItem(val textCreate: String)

@Composable
fun Selector(modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableStateOf("My Pets") }
    val gridData = listOf(SelectorItem("My Pets"), SelectorItem("Create"))

    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        content = {
            items(gridData) { item ->
                val isSelected = item.textCreate == selectedItem
                val backgroundColor = if (isSelected) Color(0xffeef1f4) else Color(0xffff9985)
                val textColor = if (item.textCreate == "Create") Color.White else Color(0xffff8066)

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp)
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(backgroundColor)
                        .clickable { selectedItem = item.textCreate }
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = item.textCreate,
                        color = textColor,
                        textAlign = TextAlign.Center,
                        lineHeight = 1.38.em,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        },
        modifier = modifier
            .width(251.dp)
            .height(30.dp)
    )
}

@Preview(widthDp = 360, heightDp = 55)
@Composable
private fun TopBarCreteMyPetItemPreview() {
    val navController = rememberNavController() // Ini hanya contoh, Anda bisa memberikan nilai navController yang sesuai
    TopBarCreteMyPetItem(navController = navController)
}