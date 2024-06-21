package com.example.bulbulapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.BlogPostCard
import com.example.bulbulapp.R
import com.example.bulbulapp.data.BlogPostData
import com.example.bulbulapp.navigation.Screen



@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun LayarBlog(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        BilahAtas(navController = navController)
        BilahPencarian()
        FilterKategori()
        KontenDaftarKartuBlog(navController = navController)
    }
}
@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BilahAtas(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {  navController.navigate(Screen.Home.route) },
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xffeef1f4))
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Kembali",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Blog",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            modifier = Modifier.weight(3f),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}
@Composable
fun BilahPencarian(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(86.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgblog2),
            contentDescription = "Gambar blog",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        androidx.compose.material3.TextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(70.dp),
            placeholder = {
                Text(
                    "Hewan Bahagia, Keluarga pun Senang!",
                    color = Color.Gray,
                    fontSize = 13.sp,
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    tint = Color.Gray,
                    contentDescription = "Ikon Pencarian"
                )
            },
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth()
                .padding(17.dp)
                .background(Color.White, shape = RoundedCornerShape(70.dp))
        )
    }
}

@Composable
fun FilterKategori(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(top = 15.dp, bottom = 10.dp)
    ) {
        val primaryColor = Color(0xFFFF8066)
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(85.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(
                text = "Semua",
                color = Color.White,
                fontSize = 10.5.sp
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Spacer added for top space
        val secondaryColor = Color(0xF2F2F3F7)
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(85.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(
                text = "Anjing",
                color = primaryColor,
                fontSize = 10.5.sp,
                textAlign = TextAlign.Justify,
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Spacer added for top space
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(85.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(
                text = "Kucing",
                color = primaryColor,
                fontSize = 10.5.sp
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Spacer added for top space
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(85.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = "Filter",
                        tint = primaryColor,
                        modifier = Modifier
                            .height(12.dp)
                            .width(12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        text = "Filter",
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = primaryColor,
                        fontSize = 10.5.sp,
                    )
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun KontenDaftarKartuBlog(navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        itemsIndexed(BlogPostData.BlogPostItems) { index, blogPostItem ->
            if (index < 3) {
                BlogPostCard(
                    blogPostItem = blogPostItem,
                    tags = blogPostItem.tags,
                    navController = navController,
                    onClick = {
                        navController.navigate(Screen.BlogDetail.createRoute(blogPostItem.id))
                    }
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun PratinjauLayarBlog() {
    val navController = rememberNavController()
    LayarBlog(navController = navController)
}
