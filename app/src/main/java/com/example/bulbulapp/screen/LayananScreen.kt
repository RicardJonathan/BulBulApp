package com.example.bulbulapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.component.ContentLayananScreen
import com.example.bulbulapp.component.CustomTextField
import com.example.bulbulapp.data.LayananListData
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.ui.theme.BulBulAppTheme

@Composable
fun LayananScreen(navController: NavHostController) {
    val layananListItems = LayananListData.listLayananItems

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ScreenTitleLayanan(navController)
        SearchBarLayanan()
        FilterButtonLayanan()
        ContentLayananScreen(navController = navController, layananList = layananListItems)
    }
}


@Composable
fun ScreenTitleLayanan(navController: NavHostController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .padding(top = 15.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.IconButton(
            onClick = { navController.navigate(Screen.Home.route)},
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xffeef1f4))
        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Kembali",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        androidx.compose.material3.Text(
            text = "layanan",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier
            .weight(1f)
            .align(Alignment.CenterVertically))
    }
}

@Composable
fun SearchBarLayanan() {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFFFFB3A3)), // Custom color
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgblog2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .height(100.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomTextField(
                leadingIcon = {
                    androidx.compose.material3.Icon(
                        Icons.Filled.Search,
                        null,
                        tint = androidx.compose.material3.LocalContentColor.current.copy(alpha = 0.3f)
                    )
                },
                trailingIcon = null,
                modifier = Modifier
                    .background(
                        MaterialTheme.colors.surface,
                        RoundedCornerShape(percent = 50)
                    )
                    .padding(4.dp)
                    .width(300.dp)
                    .height(30.dp),
                fontSize = 10.sp,
                placeholderText = "Berikan yang terbaik!"
            )
        }
    }
}

@Composable
fun FilterButtonLayanan(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        val tertiaryColor = Color(0xFFFFB3A3)
        androidx.compose.material3.Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(92.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = tertiaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            androidx.compose.material3.Text(
                text = "Semua",
                color = Color.White,
                fontSize = 11.sp
            )
        }
        Spacer(modifier = Modifier.width(20.dp)) // Spacer added for top space
        val primaryColor = Color(0xFFFF8066)
        val secondaryColor = Color(0xF2F2F3F7)
        androidx.compose.material3.Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .width(150.dp)
                .height(32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            androidx.compose.material3.Text(
                text = "Grooming",
                color = primaryColor,
                fontSize = 11.sp,
                textAlign = TextAlign.Justify,
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Spacer added for top space
        androidx.compose.material3.Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(92.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                val primaryColor = Color(0xFFFF8066)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = "Filter",
                        tint = primaryColor,
                        modifier = Modifier
                            .height(12.dp)
                            .width(12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(1.dp))
                    androidx.compose.material3.Text(
                        text = "Filter",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = primaryColor,
                        fontSize = 11.sp,
                    )
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun PreviewServiceListScreen() {
    val navController = rememberNavController()
    BulBulAppTheme {
        LayananScreen(navController = navController)
    }
}