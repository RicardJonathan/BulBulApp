package com.example.bulbulapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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

@Composable
fun ProductDetails(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(size = 40.dp)
                    .clip(shape = RoundedCornerShape(112.dp))
                    .background(color = Color(0xffeef1f4)),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        // Handle back button click here
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Gray,
                        modifier = Modifier
                            .requiredSize(size = 20.dp)
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
                textAlign = androidx.compose.ui.text.style.TextAlign.Center // Ensuring text is centered
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = R.drawable.whiskas), // Replace with your image resource
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color(0xFFFFFF1EE))  // Move background modifier before padding
                .padding(horizontal = 20.dp, vertical = 16.dp)  // Specify both horizontal and vertical padding
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp) // Space between the chips
        ) {
            AssistChip(
                onClick = {},
                label = { Text("Makanan Kering") },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color(0xFFFFFA694),
                    labelColor = Color.White
                )
            )
            AssistChip(
                onClick = {},
                label = { Text("Kucing") },
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = Color(0xFFFFFA694),
                    labelColor = Color.White
                )
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Whiskas Adult Cat Tuna 1.2 Kg",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Tentang",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = "Whiskas makanan kucing yang sehat dan seimbang, secara spesifik di formulasikan untuk memenuhi kebutuhan nutrisi kucing pada setiap masa kehidupannya. WHISKAS mengerti akan kandungan nutrisi yang dibutuhkan oleh kucing dan setiap produk secara spesifik di formulasikan dengan kandungan nutrisi yang lengkap dan seimbang.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Informasi Produk",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Kandungan Nutrisi",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Bahan Penyusun",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = "Sereal (Jagung dan/atau Gandum), Daging Unggas Olahan, Tepung Bulu Terhidrolisis, Bekatul Tanpa Lemak, Palm Stearin, Tepung Kacang Kedelai, Ikan Terhidrolisis, Tepung Gandum, Mineral, Tepung Jagung Gluten, GaransBeryodium, Vitamin, Taurin, Pewarna, Pengawet, Metionin,Perasa",
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Informasi Tambahan",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(9.dp))
        Text(
            text = "Mengandung Omega 3 & 6 dan Zinc untuk kesehatan kulit dan bulu yang indah, Mengandung Vit.A dan taurine untuk kesehatan matanya, Mengandung protein dari ikan yang segar, lemak yang baik, vitamin dan mineral yang seimbang, untuk tetap menjaga kucingmu aktif dan bahagia.",
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    ProductDetails()
}

