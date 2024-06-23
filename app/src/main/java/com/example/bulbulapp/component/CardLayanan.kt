package com.example.bulbulapp.component

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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.model.LayananListItem
import com.example.bulbulapp.navigation.Screen

@Composable
fun LayananTags(tag: String) {
    androidx.compose.material3.Surface(
        color = Color(0xFFFFB3A3),
        shape = RoundedCornerShape(5.dp),
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = tag,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}

@Composable
fun LayananCard(
    layanan: LayananListItem,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .height(250.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate(Screen.ProductDetails.createRoute(layanan.id))
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
                painter = painterResource(layanan.photo),
                contentDescription = "image",
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
                LayananTags(tag = layanan.name)
            }
            Spacer(modifier = Modifier.height(5.dp))
            androidx.compose.material3.Text(
                text = layanan.name,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            val primaryColor = Color(0xFFFF8066)
            androidx.compose.material3.Button(
                onClick = {
                    navController.navigate(Screen.LayananDetails.createRoute(layanan.id))
                },
                modifier = Modifier
                    .height(35.dp)
                    .width(200.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor
                ),
            ) {
                androidx.compose.material3.Text(
                    text = "Lihat layanan",
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
@Composable
@Preview
fun PreviewLayananCard() {
    val layanan = LayananListItem(
        id = 1,
        name = "Puppy Planet",
        rating = "4.5",
        haribuka = "Senin - Jumat",
        jambuka = "08.00 - 20.00",
        description = "Menawarkan Jasa Grooming dan Penitipan Hewan yang aman",
        tag = "Grooming",
        photo = R.drawable.imagelayaan1 // Ensure you have this drawable resource
    )
    val navController = rememberNavController()

    LayananCard(layanan = layanan, navController = navController)
}