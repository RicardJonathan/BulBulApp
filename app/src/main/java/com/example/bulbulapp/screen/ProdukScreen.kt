package com.example.bulbulapp.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
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

@Composable
fun ProdukScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ScreenTitle()
        SearchBar()
        FilterButton()
        ProductGridList()
        ProductLazyRow() // Tolong perbaiki untuk layout card-nya, tidak tampil dilayar
    }
}

@Composable
fun ScreenTitle(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .padding(top = 15.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
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
fun SearchBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(86.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgblog2),
            contentDescription = "Gambar blog",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        TextField(
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(70.dp),
            placeholder = {
                Text(
                    "Carilah Produk Yang Kamu Butuhkan",
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
                .fillMaxWidth()
                .padding(17.dp)
                .background(Color.White, shape = RoundedCornerShape(70.dp))
        )
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
        val primaryColor = Color(0xFFFF8066)
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .height(32.dp)
                .width(92.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor
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
        modifier = Modifier.padding(end = 8.dp) // Add space between tags
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            androidx.compose.material.Text(
                text = tag,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductCard(
    product: ProdukListItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        backgroundColor = Color(0xFDFDFDFD),
        shape = RoundedCornerShape(10.dp),
        elevation = 4.dp,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(product.productImage),
                contentDescription = "Product image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row( // Display product tags using ProductTags composable
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ProductTags(tag = product.productTags)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.productName,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Justify,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            val primaryColor = Color(0xFFFF8066)
            Button(
                onClick = onClick,
                modifier = Modifier
                    .height(33.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor
                ),
            ) {
                androidx.compose.material.Text(
                    "Lihat Produk",
                    fontSize = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ProductGridList(modifier: Modifier = Modifier) {
    val products = ProdukListData.ProdukListItems

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Space column
        verticalArrangement = Arrangement.spacedBy(8.dp), // Space baris
    ) {
        items(products.size) { index ->
            ProductCard(
                product = products[index],
                onClick = { /* Handle product click */ },
            )
        }
    }
}

@Composable
fun ProductLazyRow(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Produk Teratas",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray,
            )
            Text(
                text = "Lihat lainnya",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFFF8066),
                modifier = Modifier
                    .clickable { /* Handle click */ }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(ProdukListData.ProdukListItems.take(3)) { produkListItem ->
                ProductCard(
                    product = produkListItem,
                    onClick = {} // Ke Product Details Screen
                )
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun PreviewProdukScreen() {
    ProdukScreen()
}
