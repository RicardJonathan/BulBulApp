package com.example.bulbulapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.example.bulbulapp.R
import com.example.bulbulapp.data.ProdukListData
import com.example.bulbulapp.model.ProdukListItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.TextFieldDefaults
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.component.ContentProductDetails
import com.example.bulbulapp.component.ContentProductScreen
import com.example.bulbulapp.component.CustomTextField
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.ui.theme.BulBulAppTheme


@Composable
fun ProdukScreen(navController: NavHostController, onProductClicked: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenTitle(navController)
        SearchBar()
        FilterButton()
        ContentProductScreen(navController = navController)
    }
}

@Composable
fun ScreenTitle(navController: NavController, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .padding(top = 15.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { navController.navigate(Screen.Home.route)},
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
            text = "Produk",
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
fun SearchBar() {
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
                    Icon(
                        Icons.Filled.Search,
                        null,
                        tint = LocalContentColor.current.copy(alpha = 0.3f)
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
                placeholderText = "Carilah Produk Kesayanganmu"
            )
        }
    }
}


@Composable
fun FilterButton(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        val tertiaryColor = Color(0xFFFFB3A3)
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(92.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = tertiaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(
                text = "Semua",
                color = Color.White,
                fontSize = 11.sp
            )
        }
        Spacer(modifier = Modifier.width(20.dp)) // Spacer added for top space
        val primaryColor = Color(0xFFFF8066)
        val secondaryColor = Color(0xF2F2F3F7)
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .width(150.dp)
                .height(32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = secondaryColor
            ),
            shape = RoundedCornerShape(5.dp),
        ) {
            Text(
                text = "Makanan Kering",
                color = primaryColor,
                fontSize = 11.sp,
                textAlign = TextAlign.Justify,
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Spacer added for top space
        Button(
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
                        fontSize = 11.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun ProductTags(tag: String) {
    Surface(
        color = Color(0xFFFFB3A3),
        shape = RoundedCornerShape(5.dp),
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            androidx.compose.material.Text(
                text = tag,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}

@Composable
fun ProductCard(
    product: ProdukListItem,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .height(230.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate(Screen.ProductDetails.createRoute(product.productId))
            }, // Navigasi saat card diklik
        backgroundColor = Color(0xFDFDFDFD),
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(product.productImage),
                contentDescription = "Product image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ProductTags(tag = product.productTags)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = product.productName,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            val primaryColor = Color(0xFFFF8066)
            Button(
                onClick = {
                    navController.navigate(Screen.ProductDetails.createRoute(product.productId))
                },
                modifier = Modifier
                    .height(30.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor
                ),
            ) {
                Text(
                    text = "Lihat Produk",
                    fontSize = 11.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun PreviewProdukScreen() {
    val navController = rememberNavController()
    BulBulAppTheme {
        ProdukScreen(navController = navController) {
        }
    }
}