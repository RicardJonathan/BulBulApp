package com.example.bulbulapp

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.bulbulapp.component.ContentProductDetails
import com.example.bulbulapp.data.ProdukListData
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.component.RekomendasiTokoList
import com.example.bulbulapp.screen.ProductTags

@Composable
fun ProductDetailsScreen(productId: Int, navController: NavController) {
    val product = remember { ProdukListData.ProdukListItems.first { it.productId == productId } }

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(navController = navController)

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { ProductImage(productImage = product.productImage) }
            item { ProductTags(productTags = listOf(product.productTags)) }
            item { ProductTitle(productName = product.productName) }
            item { ContentProductDetails(product = product) }
            item {

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Rekomendasi Toko",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6D6F77),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            if (product.recommendations.isNotEmpty()) {
                item {
                    RekomendasiTokoList(recommendations = product.recommendations)
                }
            }
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .requiredSize(40.dp)
                .clip(RoundedCornerShape(112.dp))
                .background(Color(0xffeef1f4)),
            contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Gray,
                    modifier = Modifier.requiredSize(20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Detail Produk",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.DarkGray,
            modifier = Modifier.weight(30f),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ProductImage(productImage: Int) {
    Image(
        painter = painterResource(id = productImage),
        contentDescription = "Product Image",
        modifier = Modifier
            .fillMaxWidth()
//            .height(200.dp)
            .background(Color(0xFFFFFF1EE))
// .padding(horizontal = 20.dp, vertical = 16.dp)
    )
}

@Composable
fun ProductTags(productTags: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        productTags.forEach { tag ->
            TagsProduct(text = tag)
        }
    }
}

@Composable
fun TagsProduct(text: String) {
    Card(
        backgroundColor = Color(0xFFFFB3A3),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 6.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = Color.White, fontSize = 14.sp)
        }
    }
}

@Composable
fun ProductTitle(productName: String) {
    Text(
        text = productName,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6D6F77),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(22.dp))
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsScreenPreview() {
    val navController = rememberNavController()
    val sampleProductId = 1
    ProductDetailsScreen(productId = sampleProductId, navController = navController)
}