
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.model.BeratBadan

@Composable
fun WeightChartItem(
    beratBadanList: List<BeratBadan>,
    modifier: Modifier = Modifier, // Added modifier parameter with default value
    barColor: Color = Color(0xFFFF8066) // Default bar color set to #FF8066
) {
    val maxWeight = 10f // Maximum weight to be displayed
    val barWidth = 20.dp // Width of each bar
    val spacing = 8.dp // Spacing between bars
    val reportText = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Berat Badan (kg)", style = MaterialTheme.typography.h6, overflow = TextOverflow.Ellipsis)
            OutlinedTextField(
                value = reportText.value,
                onValueChange = { reportText.value = it },
                label = {
                    Text(
                        text = "Lihat Laporan",
                        color = Color(0xffff8066),
                        lineHeight = 1.83.em,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically)
                    )
                },
                textStyle = TextStyle(fontSize = 12.sp),
                modifier = Modifier
                    .requiredWidth(120.dp)
                    .requiredHeight(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            // Display weight bars
            beratBadanList.forEach { beratBadan ->
                WeightBar(beratBadan.berat.toFloat(), maxWeight, barWidth, barColor)
            }
        }
    }
}

@Composable
fun WeightBar(
    weight: Float,
    maxWeight: Float,
    barWidth: Dp,
    barColor: Color // Added parameter for bar color
) {
    val percentage = weight / maxWeight
    val barHeight = (200.dp * percentage).coerceAtLeast(30.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text("$weight kg", style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(barWidth)
                .height(200.dp) // Set a fixed height for the container
                .padding(bottom = 8.dp), // Padding to ensure spacing from the bottom
            contentAlignment = Alignment.BottomCenter // Align content to the bottom
        ) {
            Surface(
                modifier = Modifier
                    .width(barWidth)
                    .height(barHeight),
                shape = RoundedCornerShape(8.dp),
                color = barColor // Use the provided bar color here
            ) {}
        }
    }
}

@Preview
@Composable
fun WeightChartItemPreview() {
    val beratBadanList = listOf(
        BeratBadan(id = 1, berat = 4),
        BeratBadan(id = 2, berat = 5),
        BeratBadan(id = 3, berat = 8)
        // Add other weight data as needed
    )
    WeightChartItem(beratBadanList = beratBadanList)
}
