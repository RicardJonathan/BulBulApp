package com.example.bulbulapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.border
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun KandunganNutrisiTable(nutritionalContent: Map<String, String>) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .border(width = 1.dp, color = Color.Gray),
    ) {
        TableHeader()

        Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
        nutritionalContent.forEach { (nutrient, value) ->
            tableRow(nutrient, value)
            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun TableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFF8066)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Kandungan",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp)
                .width(165.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Divider(color = Color.White, modifier = Modifier.height(24.dp).width(1.dp))
        Text(
            text = "Jumlah",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
                .fillMaxWidth(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun tableRow(kandungan: String, jumlah: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = kandungan,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.width(180.dp)
        )
        Divider(color = Color.Gray, modifier = Modifier.height(30.dp).width(1.dp))
        Text(
            text = jumlah,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KandunganNutrisiTablePreview() {
    val sampleNutritionalContent = mapOf(
        "Lemak (min)" to "9%",
        "Serat (maks)" to "5%",
        "Kadar Air (maks)" to "12%",
        "Kalsium (maks)" to "1.4%",
        "Total Fosfor (maks)" to "1.3%"
    )
    KandunganNutrisiTable(nutritionalContent = sampleNutritionalContent)
}