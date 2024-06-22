package com.example.bulbulapp

import WeightChartItem
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.component.FiturScreen
import com.example.bulbulapp.component.MyPetsItem
import com.example.bulbulapp.component.SearchItem
import com.example.bulbulapp.component.UserSection
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.model.BeratBadan
import com.example.bulbulapp.model.MyPets
import com.example.bulbulapp.model.Profile
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.ui.theme.BulBulAppTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    profiles: List<Profile> = DummyData.listProfile,
    myPetsList: List<MyPets> = DummyData.listMyPets,
    beratBadanList: List<BeratBadan> = DummyData.listBeratBadan
) {
    Column {
        Surface(
            color = Color(0xffffb3a3),
            modifier = modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = modifier.background(Color.White)

                // Set background color to white
            ) {
                items(profiles, key = { it.id }) { profile: Profile ->
                    UserSection(profile = profile, navController = navController) { profileId: Int ->
                        navController.navigate(Screen.Home.route + "/$profileId")
                    }
                }

                // Add the new Box under UserSection
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .padding(bottom = 10.dp, top = 30.dp)
                            .wrapContentHeight()
                            .background(Color.White)
                    ) {
                        FiturScreen(navController = navController, modifier = Modifier.align(Alignment.Center))
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .wrapContentHeight()
                            .background(Color.White)
                    ) {
                        MyPetsItem(myPetsList = myPetsList,
                            modifier = Modifier.align(Alignment.Center),
                            navController = navController)
                    }
                }

                // Add WeightChartItem below MyPetsItem
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 10.dp)
                            .wrapContentHeight()
                            .background(Color.White)
                    ) {
                        WeightChartItem(beratBadanList = beratBadanList, modifier = Modifier.align(Alignment.Center), navController = navController)
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .wrapContentHeight()
                            .background(Color.White)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 16.dp, end = 10.dp)
                        ){
                            rekomendasisection()
                            Spacer(modifier = Modifier.height(20.dp))
                            BlogRowList(blogRowItems = com.example.bulbulapp.data.BlogPostRow.BlogRowItems)
                        }

                    }
                }



                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    BulBulAppTheme {
        HomeScreen(navController = rememberNavController())
    }
}