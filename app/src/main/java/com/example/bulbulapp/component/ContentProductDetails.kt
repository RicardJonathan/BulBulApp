package com.example.bulbulapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.model.ProdukListItem
import com.example.bulbulapp.data.ProdukListData

@Composable
fun ContentProductDetails(modifier: Modifier = Modifier, product: ProdukListItem) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding (top = 8.dp)
            .background(Color.White)
    ) {
        ProductAbout(productAbout = product.productAbout)
        InformasiProduk(productInfo = product.productInfo)
        KandunganNutrisiTable(nutritionalContent = product.productNutritionalContent)
        ProductIngredients(productIngredients = product.productIngredients)
        AdditionalInfo(additionalInfo = product.additionalInfo)
    }
}

@Composable
fun ProductAbout(productAbout: String) {
    Text(
        text = "Tentang",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6D6F77),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = Modifier.height(9.dp))
    Text(
        text = productAbout,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        color = Color(0xFF6D6F77),
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun InformasiProduk(productInfo: Map<String, String>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Informasi Produk",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF6D6F77),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(22.dp))
        InfoTable(productInfo = productInfo)
    }
}

@Composable
fun InfoTable(productInfo: Map<String, String>) {
    Column {
        productInfo.forEach { (label, value) ->
            InfoRow(label = label, value = value)
            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 16.sp, modifier = Modifier.weight(1f), color = Color(0xFF6D6F77))
        Text(text = value, fontSize = 16.sp, modifier = Modifier.weight(1f), color = Color(0xFF6D6F77))
    }
}

@Composable
fun ProductIngredients(productIngredients: String) {
    Text(
        text = "Bahan Penyusun",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6D6F77),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = productIngredients,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        color = Color.DarkGray,
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun AdditionalInfo(additionalInfo: String) {
    Text(
        text = "Informasi Tambahan",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF6D6F77),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = Modifier.height(9.dp))
    Text(
        text = additionalInfo,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        color = Color(0xFF6D6F77),
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun ContentProductDetailsPreview() {
    val sampleProduct = ProdukListData.ProdukListItems[7]
    ContentProductDetails(product = sampleProduct)
}
