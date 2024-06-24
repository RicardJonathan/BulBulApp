package com.example.bulbulapp.screen

import WeightChartItem
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.bulbulapp.Pet
import com.example.bulbulapp.R
import com.example.bulbulapp.component.AktivitasBulBulItem
import com.example.bulbulapp.model.BeratBadan

@Composable

fun DetailPetsScreen(navController: NavController, petName: String?) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = petName ?:"BulBul",
                        color = Color(0xff6d6f77),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 1.38.em
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 48.dp) // Adjust the padding to center the title correctly
                    )
                },
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "arrow-left",
                            modifier = Modifier
                                .requiredSize(size = 25.dp)
                                .background(color = Color(0xffeef1f4))
                                .padding(4.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                petDetailsList.forEach { petDetails ->
                    PetDetailsCard(petDetails = petDetails, modifier = Modifier.padding(vertical = 16.dp))
                }
                InfoMyPets(modifier = Modifier.padding(vertical = 16.dp))
                UkurandanAktivitas(modifier = Modifier.padding(vertical = 16.dp))
                Kalorihariandanhidangan(modifier = Modifier.padding(vertical = 16.dp))
                val beratBadanList = listOf(
                    BeratBadan(id = 1, berat = 4),
                    BeratBadan(id = 2, berat = 5),
                    BeratBadan(id = 3, berat = 8)
                )
                WeightChartItem(beratBadanList = beratBadanList, modifier = Modifier.padding(vertical = 16.dp), navController = navController)
                AktivitasBulBulItem(modifier = Modifier.padding(vertical = 16.dp))
            }
        }
    }
}
data class PetDetails(val name: String, val umur: String, val berat: String)

val petDetailsList = listOf(
    PetDetails(
        name = "Bogang", umur = "1 tahun", berat = "3 kg",
        ),
)
    // Add more pet details as needed

@Composable
fun PetDetailsCard(petDetails: PetDetails, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(width = 324.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.White)
            .padding(horizontal = 10.dp, vertical = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pet1),
            contentDescription = "Image placeholder",
            modifier = Modifier
                .requiredWidth(width = 74.dp)
                .requiredHeight(height = 60.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .border(border = BorderStroke(1.dp, Color(0xffd0d2dd)),
                    shape = RoundedCornerShape(5.dp))
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.Top),
            modifier = Modifier
                .requiredWidth(width = 224.dp)
                    .padding(8.dp)
        ) {
            Text(
                text = petDetails.name,
                color = Color(0xff6d6f77),
                lineHeight = 1.em,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
            ) {
                Column {
                    Text(
                        text = "Umur",
                        color = Color(0xff6d6f77),
                        lineHeight = 1.38.em,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                    )

                    Text(
                        text = petDetails.umur,
                        color = Color(0xff6d6f77),
                        lineHeight = 1.38.em,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                            .padding(top = 4.dp)
                    )
                }

                Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Text(
                        text = "Berat",
                        color = Color(0xff6d6f77),
                        lineHeight = 1.38.em,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                    )

                    Text(
                        text = petDetails.berat,
                        color = Color(0xff6d6f77),
                        lineHeight = 1.38.em,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .padding(top = 4.dp) // Atur jarak antara berat dan kg
                    )
                }
            }
            }
        }
    }

@Composable
fun InfoMyPets(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(286.dp)
            .height(28.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(286.dp)
        ) {
            Text(
                text = "Info My Pets",
                color = Color(0xff6d6f77),
                lineHeight = 2.25.em,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .width(323.dp)
                    .height(28.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.exclamation_circle),
            contentDescription = "exclamation-circle",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 300.dp, y = 0.dp)
                .size(30.dp)
        )
    }
}

@Composable
fun UkurandanAktivitas(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(width = 361.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(width = 123.dp)
                .requiredHeight(height = 132.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 123.dp)
                    .requiredHeight(height = 132.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 123.dp)
                        .requiredHeight(height = 132.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Color.White))
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 123.dp)
                        .requiredHeight(height = 78.dp)
                ) {
                    BreedSizemedium(
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .offset(x = (-0.5).dp,
                                y = 3.256755828857422.dp))
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(26.dp, Alignment.CenterHorizontally),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 0.dp,
                            y = 86.dp)
                        .requiredWidth(width = 123.dp)
                        .requiredHeight(height = 46.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically),
                        modifier = Modifier
                            .requiredWidth(width = 120.dp)
                            .requiredHeight(height = 45.dp)
                    ) {
                        Text(
                            text = "Ukuran Badan",
                            color = Color(0xffa9acb8),
                            textAlign = TextAlign.Center,
                            lineHeight = 10.42.em,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .requiredWidth(width = 120.dp))
                        Text(
                            text = "Medium",
                            color = Color(0xff6d6f77),
                            textAlign = TextAlign.Center,
                            lineHeight = 8.93.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .requiredWidth(width = 120.dp))
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .requiredWidth(width = 123.dp)
                .requiredHeight(height = 131.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 123.dp)
                    .requiredHeight(height = 131.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 123.dp)
                        .requiredHeight(height = 131.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Color.White))
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 123.dp)
                        .requiredHeight(height = 78.dp)
                ) {
                    ActivityLevelhighActivity(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 1.dp,
                                y = 1.dp))
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(26.dp, Alignment.CenterHorizontally),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 0.dp,
                            y = 85.dp)
                        .requiredWidth(width = 123.dp)
                        .requiredHeight(height = 46.dp)
                        .padding(horizontal = 5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.CenterVertically),
                        modifier = Modifier
                            .requiredWidth(width = 120.dp)
                            .requiredHeight(height = 45.dp)
                    ) {
                        Text(
                            text = "Tingkat Aktivitas",
                            color = Color(0xffa9acb8),
                            textAlign = TextAlign.Center,
                            lineHeight = 10.42.em,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .requiredWidth(width = 120.dp))
                        Text(
                            text = "High Activity",
                            color = Color(0xff6d6f77),
                            textAlign = TextAlign.Center,
                            lineHeight = 8.93.em,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium),
                            modifier = Modifier
                                .requiredWidth(width = 120.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun BreedSizemedium(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 121.dp)
            .requiredHeight(height = 85.dp)
            .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.catbig),
            contentDescription = "cat-medium 2",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 31.dp,
                    y = 17.dp)
                .requiredSize(size = 59.dp))
    }
}

@Composable
fun ActivityLevelhighActivity(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 121.dp)
            .requiredHeight(height = 85.dp)
            .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.tingkataktifitas),
            contentDescription = "Cat - High Activity 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 18.dp,
                    y = 15.dp)
                .requiredWidth(width = 85.dp)
                .requiredHeight(height = 55.dp))
    }
}

@Composable
fun Kalorihariandanhidangan(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally),
        modifier = modifier
            .requiredWidth(width = 361.dp)
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(width = 123.dp)
                .requiredHeight(height = 79.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.White)
        ) {
            Text(
                text = "Kalori Harian",
                color = Color(0xff6d6f77),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 9.dp,
                        y = 11.dp)
                    .requiredWidth(width = 105.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.CenterHorizontally),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 8.5.dp,
                        y = 39.dp)
                    .requiredWidth(width = 106.dp)
            ) {
                Text(
                    text = "401",
                    color = Color(0xff6d6f77),
                    textAlign = TextAlign.Center,
                    lineHeight = 6.25.em,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium))
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 40.dp)
                        .requiredHeight(height = 25.dp)
                ) {
                    Text(
                        text = "Kcal",
                        color = Color(0xff545f71),
                        lineHeight = 12.5.em,
                        style = TextStyle(
                            fontSize = 10.sp),
                        modifier = Modifier
                            .requiredWidth(width = 39.dp))
                    Text(
                        text = "Per Hari",
                        color = Color(0xff545f71),
                        lineHeight = 12.5.em,
                        style = TextStyle(
                            fontSize = 10.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.25.dp,
                                y = 12.dp)
                            .requiredWidth(width = 40.dp))
                }
            }
        }
        Box(
            modifier = Modifier
                .requiredWidth(width = 123.dp)
                .requiredHeight(height = 79.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 8.5.dp,
                        y = 11.dp)
            ) {
                Text(
                    text = "Hidangan",
                    color = Color(0xff545f71),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium),
                    modifier = Modifier
                        .requiredWidth(width = 105.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.CenterHorizontally),
                    modifier = Modifier
                        .requiredWidth(width = 106.dp)
                ) {
                    Text(
                        text = "52",
                        color = Color(0xff6d6f77),
                        textAlign = TextAlign.Center,
                        lineHeight = 6.25.em,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium))
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 43.dp)
                            .requiredHeight(height = 25.dp)
                    ) {
                        Text(
                            text = "Gram",
                            color = Color(0xff545f71),
                            lineHeight = 12.5.em,
                            style = TextStyle(
                                fontSize = 10.sp),
                            modifier = Modifier
                                .requiredWidth(width = 43.dp))
                        Text(
                            text = "Per Hari",
                            color = Color(0xff545f71),
                            lineHeight = 12.5.em,
                            style = TextStyle(
                                fontSize = 10.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 0.125.dp,
                                    y = 12.dp)
                                .requiredWidth(width = 43.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPetsScreenPreview() {
    val navController = rememberNavController()
    DetailPetsScreen(navController = navController, petName = "BulBul2")
}
