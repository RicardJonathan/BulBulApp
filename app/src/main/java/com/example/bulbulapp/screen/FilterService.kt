package com.example.bulbulapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun FilterScreen() {
    var selectedCategory by remember { mutableStateOf("Semua") }
    var selectedSort by remember { mutableStateOf("Terdekat") }

    val categories = listOf("Semua", "Grooming", "Pet Shop", "Pet Hotel", "Pet Salon", "Pet Clinic", "Training")
    val sortOptions = listOf("Terdekat", "Review Terbaik")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Filter",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Kategori",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            categories.forEach { category ->
                Button(
                    onClick = { selectedCategory = category },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (selectedCategory == category) Color(0xFFFF7961) else Color(0xFFF3F5F9),
                        contentColor = if (selectedCategory == category) Color.White else Color(0xFF6C727A)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = category)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Urutkan",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            sortOptions.forEach { sortOption ->
                Button(
                    onClick = { selectedSort = sortOption },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = if (selectedSort == sortOption) Color(0xFFFF8066) else Color(0xFFF3F5F9),
                        contentColor = if (selectedSort == sortOption) Color.White else Color(0xFF6C727A)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(text = sortOption)
                }
            }
        }
    }
}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    mainAxisSpacing: Dp = 0.dp,
    crossAxisSpacing: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val rows = mutableListOf<MeasuredRow>()

        var currentRow = MeasuredRow(mainAxisSpacing)
        var rowWidth = 0
        var rowHeight = 0

        measurables.forEach { measurable ->
            val placeable = measurable.measure(constraints)
            if (rowWidth + placeable.width > constraints.maxWidth) {
                rows.add(currentRow)
                currentRow = MeasuredRow(mainAxisSpacing)
                rowWidth = 0
                rowHeight = 0
            }
            currentRow.add(placeable)
            rowWidth += placeable.width + mainAxisSpacing.toPx().toInt()
            rowHeight = maxOf(rowHeight, placeable.height)
        }
        if (currentRow.isNotEmpty()) {
            rows.add(currentRow)
        }

        val height = rows.sumOf { it.height + crossAxisSpacing.toPx().toInt() }
        layout(constraints.maxWidth, height) {
            var yPosition = 0

            rows.forEach { row ->
                var xPosition = 0
                row.height = rowHeight
                row.placeables.forEach { placeable ->
                    placeable.placeRelative(x = xPosition, y = yPosition)
                    xPosition += placeable.width + mainAxisSpacing.toPx().toInt()
                }
                yPosition += rowHeight + crossAxisSpacing.toPx().toInt()
            }
        }
    }
}

class MeasuredRow(private val mainAxisSpacing: Dp) {
    val placeables = mutableListOf<Placeable>()
    var height = 0

    fun add(placeable: Placeable) {
        placeables.add(placeable)
        height = maxOf(height, placeable.height)
    }

    fun isNotEmpty(): Boolean {
        return placeables.isNotEmpty()
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    MaterialTheme {
        FilterScreen()
    }
}
