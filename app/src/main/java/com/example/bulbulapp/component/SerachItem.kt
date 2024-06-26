package com.example.bulbulapp.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun SearchItem(
    profile: Profile,
    navController: NavController, // Tambahkan parameter NavController di sini
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    val backgroundImage: Painter = painterResource(id = R.drawable.bghome)
    Box(
        modifier = modifier
            .width(360.dp)
            .clip(RoundedCornerShape(16.dp))
            .paint(
                painter = backgroundImage,
                contentScale = ContentScale.Crop // Set contentScale here once
            )
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
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
                            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "search",
                            modifier = Modifier.requiredSize(30.dp)
                        )
                    },
                    shape = RoundedCornerShape(0.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White
                    ),
                    selected = true,
                    onClick = {}
                )
                Icon(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "Settings Icon",
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Bell Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = profile.photo),
                    contentDescription = "Gambar user",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .clickable {
                            navController.navigate(Screen.ProfileScreen.route) // Gunakan navController yang diberikan
                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Halo, ${profile.name}! Selamat Datang",
                    color = Color.White,
                    lineHeight = 1.5.em,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(widthDp = 360, heightDp = 160)
@Composable
private fun SearchItemPreview() {
    val profile = Profile(id = 1, name = "Made", photo = R.drawable.user)
    SearchItem(profile = profile, onItemClicked = {}, navController = rememberNavController())
}
