package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.model.PetShop


@Composable
fun CardPetsShop(modifier: Modifier = Modifier, petShop: PetShop, onItemClicked: (Int) -> Unit) {
    androidx.compose.material.Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = modifier
            .clickable { onItemClicked(petShop.id) }
            .size(width = 150.dp, height = 188.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = petShop.photo),
                contentDescription = petShop.name,
                modifier = Modifier
                    .size(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(3.dp))
            Text(
                text = petShop.name,
                color = Color(0xff656565),
                lineHeight = 13.89.em,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = petShop.description,
                color = Color(0xff9ba5b7),
                lineHeight = 13.89.em,
                style = TextStyle(
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPetsShopPreview() {
    val dummyPetShop = DummyData.listPetShop.first() // Ambil item pertama dari listPetShop sebagai contoh
    CardPetsShop(petShop = dummyPetShop, onItemClicked = {})
}