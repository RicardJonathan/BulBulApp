import androidx.compose.foundation.background
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
import androidx.compose.material.TextFieldDefaults
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
    modifier: Modifier = Modifier,
    barColor: Color = Color(0xFFFF8066)
) {
    val maxWeight = 10f
    val barWidth = 20.dp
    val spacing = 8.dp
    val chartHeight = 200.dp // Set the height of the chart
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
            Text(
                text = "Berat",
                color = Color.Black,  // Ubah warna menjadi hitam
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(28.dp)
                    .background(Color(0xffff8066), shape = RoundedCornerShape(4.dp)), // Latar belakang berwarna dengan sudut membulat
                contentAlignment = Alignment.Center // Menyelaraskan teks ke tengah
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(28.dp)
                        .background(Color(0xffff8066), shape = RoundedCornerShape(4.dp)), // Latar belakang berwarna dengan sudut membulat
                    contentAlignment = Alignment.Center // Menyelaraskan teks ke tengah
                ) {
                    Text(
                        text = "Lihat Laporan",
                        color = Color.White, // Warna teks putih
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(chartHeight)
                    .padding(end = 8.dp)
            ) {
                // Reversed order for the y-axis labels
                for (i in 5 downTo 0) {
                    Text(
                        text = "${i * 2} kg",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    if (i > 0) Spacer(modifier = Modifier.weight(1f, fill = true))
                }
            }
            beratBadanList.forEach { beratBadan ->
                WeightBar(beratBadan.berat.toFloat(), maxWeight, barWidth, chartHeight, barColor)
            }
        }
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
    val percentage = weight / maxWeight
    val barHeight = (chartHeight * percentage).coerceAtLeast(30.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {

        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(barWidth)
                .height(chartHeight)
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Surface(
                modifier = Modifier
                    .width(barWidth)
                    .height(barHeight),
                shape = RoundedCornerShape(8.dp),
                color = barColor
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
    )
    WeightChartItem(beratBadanList = beratBadanList)
}