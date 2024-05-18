package com.example.bulbulapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.bulbulapp.data.OnBoardingData
import com.example.bulbulapp.model.OnBoardingItem
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val onBoardings = OnBoardingData.onBoardingItems

    OnBoardingContent(
        onBoardings = onBoardings,
        moveToLogin = {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.OnBoarding.route) {
                    inclusive = true
                }
            }
        },
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingContent(
    onBoardings: List<OnBoardingItem>,
    moveToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { onBoardings.size })
    val (selectedPage, setSelectedPage) = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            setSelectedPage(page)
        }
    }

    Scaffold {
        Column(modifier = modifier.padding(it)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(0.6f)
            ) { page ->
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(
                        onBoardings[page].resId
                    )
                )

                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                ) {
                    Text(
                        text = onBoardings[page].title,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFFFF8066) // Ubah warna teks menjadi #FF8066
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    Text(
                        text = onBoardings[page].description,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    LottieAnimation(
                        composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier
                            .width(400.dp)  // Mengatur lebar animasi menjadi 200dp
                            .height(400.dp) // Mengatur tinggi animasi menjadi 200dp
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                for (i in onBoardings.indices) {
                    Box(
                        modifier = Modifier
                            .padding(end = if (i == onBoardings.size - 1) 0.dp else 5.dp)
                            .width(if (i == selectedPage) 20.dp else 10.dp)
                            .height(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                ButtonDefaults.buttonColors(
                                    containerColor = if (i == selectedPage) Color(0xFFFF8066) else MaterialTheme.colorScheme.background
                                ).containerColor
                            )
                    )


                }
            }

            if (selectedPage != onBoardings.size - 1) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TextButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(onBoardings.size - 1)
                            }
                        },
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(
                            text = "Skip",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFFFF8066) // Ubah warna teks sesuai keinginan
                        )
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                val nextPage = selectedPage + 1
                                pagerState.animateScrollToPage(nextPage)
                            }
                        },
                        modifier = Modifier.height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF8066), // Mengubah warna latar belakang

                        )
                    ) {
                        Text(
                            text = "Next",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            if (selectedPage == onBoardings.size - 1) {
                Button(
                    onClick = {
                        moveToLogin()
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(MaterialTheme.shapes.extraLarge),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF8066) // Mengubah warna latar belakang sesuai keinginan
                    )
                ) {
                    Text(
                        text = "Mulai",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    // For preview purposes, create a dummy NavController
    val navController = rememberNavController()
    OnBoardingScreen(navController = navController)
}
