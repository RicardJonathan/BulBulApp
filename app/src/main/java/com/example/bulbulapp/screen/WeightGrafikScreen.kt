package com.example.bulbulapp.screen

import WeightBar
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.component.CatatanBeratBadanTurunItem
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.model.BeratBadan

@Composable
fun WeightGrafikScreen(navController: NavController) {
    val listBeratBadan = DummyData.listBeratBadan
    val dateState = remember { mutableStateOf(TextFieldValue()) }
    val weightState = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "BulBul",
                        color = Color(0xff6d6f77),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 1.38.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 48.dp) // Sesuaikan padding untuk memusatkan judul
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
                                .size(25.dp)
                                .clip(RoundedCornerShape(112.dp))
                                .background(color = Color(0xffeef1f4))
                                .padding(4.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                WeightChart(
                    beratBadanList = listBeratBadan,
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                UserInputFields(dateState, weightState)
                Spacer(modifier = Modifier.height(16.dp))
                CatatanBeratBadan(
                    modifier = Modifier.fillMaxWidth(),
                    imagePainter = painterResource(id = R.drawable.polygon1) // Contoh penggunaan imagePainter
                )
                Spacer(modifier = Modifier.height(16.dp))
                CatatanBeratBadanTurunItem(
                    modifier = Modifier.fillMaxWidth(),
                    imagePainter = painterResource(id = R.drawable.polygonturun) // Contoh penggunaan imagePainter
                )
            }
        }
    )
}

@Composable
fun WeightChart(
    beratBadanList: List<BeratBadan>,
    modifier: Modifier = Modifier,
    barColor: Color = Color(0xFFFF8066),
    contentPadding: PaddingValues
) {
    val maxWeight = 10f
    val barWidth = 20.dp
    val spacing = 8.dp
    val chartHeight = 200.dp // Set the height of the chart

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(50.dp)
                    .height(chartHeight)
            ) {
                for (i in 5 downTo 0) {
                    Text(text = "${i * 2} kg")
                    if (i > 0) Spacer(modifier = Modifier.weight(1f))
                }
            }
            beratBadanList.forEach { beratBadan ->
                WeightBar(
                    weight = beratBadan.berat.toFloat(),
                    maxWeight = maxWeight,
                    barWidth = barWidth,
                    chartHeight = chartHeight,
                    barColor = barColor
                )
            }
        }
        Text(
            text = "Mohon gunakan timbangan untuk hasil yang optimal.",
            color = Color(0xff6d6f77),
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun WeightBar(
    weight: Float,
    maxWeight: Float,
    barWidth: Dp,
    chartHeight: Dp,
    barColor: Color
) {
    val weightPercentage = (weight / maxWeight).coerceIn(0f, 1f)
    val barHeight = chartHeight * weightPercentage
    Box(
        modifier = Modifier
            .width(barWidth)
            .height(barHeight)
            .background(barColor)
    )
}

@Composable
fun CatatanBeratBadan(modifier: Modifier = Modifier, imagePainter: Painter) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(354.dp)
            .requiredHeight(80.dp)
            .padding(start = 10.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
    ) {
        Box(
            modifier = Modifier
                .requiredWidth(335.dp)
                .requiredHeight(70.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xffff8066))
                .padding(horizontal = 20.dp, vertical = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Berat Badan",
                        color = Color.White,
                        style = TextStyle(fontSize = 12.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center)
                    )
                    Text(
                        text = "4 kg - 02 May 2024",
                        color = Color.White,
                        style = TextStyle(fontSize = 10.sp),
                        modifier = Modifier.wrapContentSize(align = Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Spacer to push the content to the right
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Image(
                        painter = imagePainter,
                        contentDescription = "image",
                        modifier = Modifier
                            .requiredWidth(20.dp) // Adjust width to make the image smaller
                            .requiredHeight(20.dp) // Adjust height to make the image smaller
                            .clip(RoundedCornerShape(5.dp))
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(3.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Berat Naik",
                            color = Color.White,
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.wrapContentSize(align = Alignment.CenterEnd)
                        )
                        Text(
                            text = "1 kg",
                            color = Color.White,
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.Medium),
                            modifier = Modifier.wrapContentSize(align = Alignment.CenterEnd)
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun UserInputFields(dateState: MutableState<TextFieldValue>, weightState: MutableState<TextFieldValue>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = dateState.value,
            onValueChange = { dateState.value = it },
            label = { Text("Tanggal") },
            placeholder = { Text("DD/MM/YY") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "calendar icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        )
        OutlinedTextField(
            value = weightState.value,
            onValueChange = { weightState.value = it },
            label = { Text("Berat") },
            placeholder = { Text("0 kg") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.weight),
                    contentDescription = "weight icon",
                    modifier = Modifier.size(20.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle the add action */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF8066))
        ) {
            Text(
                text = "Tambahkan",
                color = Color.White,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeightGrafikScreenPreview() {
    val navController = rememberNavController()
    WeightGrafikScreen(navController = navController)
}
