package com.example.bulbulapp.component

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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.model.Profile
import com.example.bulbulapp.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun UserSection(
    profile: Profile,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    val backgroundImage: Painter = painterResource(id = R.drawable.bghome)
    Box(
        modifier = modifier
            .fillMaxWidth() // Fill the available width
            .height(170.dp) // Set height
            .background(Color(0xffffb3a3)) // Set background color
            .padding(10.dp) // Set padding
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                InputChip(
                    label = {
                        Text(
                            text = "Berikan yang terbaik untuk hewanmu",
                            color = Color(0xff9ba5b7),
                            lineHeight = 1.58.sp,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 12.sp
                            ),
                            modifier = Modifier
                                .wrapContentHeight(align = Alignment.CenterVertically)
                                .padding(10.dp)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "search",
                            tint = Color.Gray, // Ubah warna ikon menjadi abu-abu muda
                            modifier = Modifier.requiredSize(30.dp)
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Transparent // Use transparent for chip background
                    ),
                    selected = true,
                    onClick = {}
                )
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Settings Icon",
                    tint = Color.White, // Tint untuk membuat ikon putih
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Bell Icon",
                    tint = Color.White, // Tint untuk membuat ikon putih
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column {
                    Text(
                        text = "Halo, ${profile.name}!",
                        color = Color.White, // Set text color to match background readability
                        lineHeight = 1.5.em,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Selamat Datang",
                        color = Color.White, // Set text color to match background readability
                        lineHeight = 1.5.em,
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Spacer(modifier = Modifier.width(100.dp))
                Image(
                    painter = painterResource(id = profile.photo),
                    contentDescription = "Gambar user",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate(Screen.ProfileScreen.route) // Use navController provided
                        }
                )

            }

        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
private fun SearchItemPreview() {
    val profile = Profile(id = 1, name = "Pawrents", photo = R.drawable.user)
    UserSection(profile = profile, onItemClicked = {}, navController = rememberNavController())
}