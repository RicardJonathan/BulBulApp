package com.example.bulbulapp.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun ItemInputDataHewanSaya(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Properti1Default()
        JenisHewan()
        JenisKelamin()
        UkuranHewanmodifier(modifier = Modifier.fillMaxSize())
        KondisiKesehatan()
    }
}

@Composable
fun Properti1Default(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp)
    ) {
        TipePlaceholder(modifier)
    }
}

@Composable
fun TipePlaceholder(modifier: Modifier = Modifier) {
    CommonTextField(
        label = "Nama",
        placeholder = "Nama",
        modifier = modifier
    )
}

@Composable
fun JenisHewan(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp)
    ) {
        Properti1KosongDataJenisHewan(modifier)
    }
}

@Composable
fun Properti1KosongDataJenisHewan(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp) // Ensure consistent height for both composables
    ) {
        CommonTextField(
            label = "Ras",
            placeholder = "Ras",
            isDropdown = true,
            modifier = modifier
        )
    }
}

@Composable
fun CommonTextField(
    label: String,
    placeholder: String,
    isDropdown: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp, Alignment.Bottom),
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            color = Color(0xff6d6f77),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                .background(color = Color.White)
                .border(
                    border = BorderStroke(1.dp, Color(0xff545f71)),
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(12.dp)
        ) {
            Text(
                text = placeholder,
                color = Color(0xff9ba5b7),
                lineHeight = 1.57.em,
                style = TextStyle(fontSize = 14.sp),
                modifier = Modifier.weight(1f)
            )
            if (isDropdown) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "selector"
                )
            }
        }
    }
}

@Composable
fun JenisKelamin(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(62.dp)
    ) {
        Text(
            text = "Jenis Kelamin",
            color = Color(0xff545f71),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 8.dp)
                .fillMaxWidth()
                .height(28.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Properti1DefaultJenisKelamin(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 38.dp)
                .fillMaxWidth()
                .height(24.dp)
        )
    }
}

@Composable
fun Properti1DefaultJenisKelamin(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Properti1KosongDataJenisKelamin()
    }
}

@Composable
fun Properti1KosongDataJenisKelamin(modifier: Modifier = Modifier) {
    var selectedGender by remember { mutableStateOf<String?>(null) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .requiredWidth(324.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(155.dp)
                .clickable { selectedGender = "Betina" }
        ) {
            Icon(
                imageVector = if (selectedGender == "Betina") Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked,
                contentDescription = "Radio button",
                tint = Color(0xff545f71),
                modifier = Modifier.clip(shape = RoundedCornerShape(3.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Betina",
                color = Color(0xff545f71),
                lineHeight = 1.57.em,
                style = TextStyle(fontSize = 14.sp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(155.dp)
                .clickable { selectedGender = "Jantan" }
        ) {
            Icon(
                imageVector = if (selectedGender == "Jantan") Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked,
                contentDescription = "Radio button",
                tint = Color(0xff545f71),
                modifier = Modifier.clip(shape = RoundedCornerShape(3.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Jantan",
                color = Color(0xff545f71),
                lineHeight = 1.57.em,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}

data class BeratdanUmur(val textLabel: String, val textText: String, val iconChartpie: Int)

@Composable
fun UkuranHewanmodifier(modifier: Modifier = Modifier) {
    val gridData = listOf(
        BeratdanUmur("Berat", "0 kg", R.drawable.chartpie),
        BeratdanUmur("Umur", "0 th", R.drawable.calendar)
    )
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(10.dp), // Menambahkan jarak antar elemen
        content = {
            items(gridData) { item ->
                TypePlaceholders(
                    textLabel = item.textLabel,
                    textText = item.textText,
                    iconChartpie = item.iconChartpie
                )
            }
        },
        modifier = modifier
            .requiredWidth(320.dp)
            .requiredHeight(75.dp)
    )
}

@Composable
fun TypePlaceholders(
    textLabel: String,
    textText: String,
    iconChartpie: Int,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp, Alignment.Bottom),
        modifier = modifier
            .width(150.dp), // Menetapkan lebar konsisten untuk semua elemen
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = textLabel,
            color = Color(0xff6d6f77),
            lineHeight = 1.36.em,
            style = TextStyle(fontSize = 14.sp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(48.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .border(BorderStroke(1.dp, Color(0xff6d6f77)), RoundedCornerShape(6.dp))
                .padding(12.dp)
        ) {
            Text(
                text = textText,
                color = Color(0xff9ba5b7),
                lineHeight = 1.83.em,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = iconChartpie),
                contentDescription = "chartpie",
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun KondisiKesehatan(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(62.dp)
    ) {
        Text(
            text = "Kondisi Kesehatan",
            color = Color(0xff545f71),
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 8.dp)
                .fillMaxWidth()
                .height(28.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Properti1DefaultKondisiKesehatan(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 38.dp)
                .fillMaxWidth()
                .height(24.dp)
        )
    }
}

@Composable
fun Properti1DefaultKondisiKesehatan(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Properti1KosongDataKondisiKesehatan()
    }
}

@Composable
fun Properti1KosongDataKondisiKesehatan(modifier: Modifier = Modifier) {
    var selectedCondition by remember { mutableStateOf<String?>(null) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.requiredWidth(324.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(155.dp)
                .clickable { selectedCondition = "Vaksinasi" }
        ) {
            Icon(
                imageVector = if (selectedCondition == "Vaksinasi") Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked,
                contentDescription = "Radio button",
                tint = Color(0xff545f71),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(3.dp))
                    .offset(x = 1.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Vaksinasi",
                color = Color(0xff545f71),
                lineHeight = 1.57.em,
                style = TextStyle(fontSize = 14.sp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .requiredWidth(155.dp)
                .clickable { selectedCondition = "Sterilisasi" }
        ) {
            Icon(
                imageVector = if (selectedCondition == "Sterilisasi") Icons.Default.RadioButtonChecked else Icons.Default.RadioButtonUnchecked,
                contentDescription = "Radio button",
                tint = Color(0xff545f71),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(3.dp))
                    .offset(x = 1.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sterilisasi",
                color = Color(0xff545f71),
                lineHeight = 1.57.em,
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewItemInputDataHewanSaya() {
    ItemInputDataHewanSaya()
}