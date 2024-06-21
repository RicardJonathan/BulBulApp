package com.example.bulbulapp.component


import androidx.compose.runtime.LaunchedEffect
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.data.ProdukListData
import com.example.bulbulapp.model.RekomendasiTokoItem

@Composable
fun RekomendasiTokoList(recommendations: List<RekomendasiTokoItem>) {
    if (recommendations.isEmpty()) {
        Text("Tidak ada rekomendasi toko saat ini")
    } else {
        Column {
            recommendations.forEach { item ->
                RekomendasiTokoItem(item)
            }
        }
    }
}

@Composable
fun RekomendasiTokoItem(item: RekomendasiTokoItem) {
    val context = LocalContext.current

    LaunchedEffect(item) {
        println("Rendering item: ${item.description}")
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding (5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = item.logoImage),
                contentDescription = "Logo Toko",
                modifier = Modifier.size(70.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = Color.Black)) {
                            append("Rp.")
                        }
                        append(String.format("%,d", item.price))
                    },
                )
                Text(
                    text = item.description,
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.width(120.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            val primaryColor = Color(0xFFFF8066)
            Button(
                onClick = { openLink(context, item.url) },
                modifier = Modifier.padding(top = 2.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            ) {
                Text(
                    "Beli Sekarang",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.width(170.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private fun openLink(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun PreviewRekomendasiTokoList() {
    val product = ProdukListData.ProdukListItems.first()
    val recommendations = product.recommendations
    RekomendasiTokoList(recommendations = recommendations)
}
