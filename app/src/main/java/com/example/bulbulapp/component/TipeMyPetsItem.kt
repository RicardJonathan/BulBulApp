import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.bulbulapp.R

@Composable
fun TipeMyPetsItem(fillMaxWidth: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "Tipe My Pets",
            color = Color(0xff6d6f77),
            lineHeight = 2.57.em,
            style = MaterialTheme.typography.body1.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(0.dp) // Space between items
        ) {
            Column(modifier = Modifier.weight(0.3f)) { // Mengatur weight menjadi 0.5f untuk memperkecil lebar
                CustomImage(drawableId = R.drawable.dog)
                CustomText(text = "Anjing")
            }

            Column(modifier = Modifier.weight(0.5f)) { // Mengatur weight menjadi 0.5f untuk memperkecil lebar
                CustomImage(drawableId = R.drawable.cat)
                CustomText(text = "Kucing")
            }
        }
    }
}

@Composable
fun CustomImage(drawableId: Int, shape: RoundedCornerShape = RoundedCornerShape(8.dp)) {
    Card(
        modifier = Modifier
            .size(80.dp) // Set the size to 80.dp x 80.dp
            .padding(bottom = 8.dp), // Add padding at the bottom to create space for the text
        elevation = 3.dp,
        shape = shape
    ) {
        Image(
            painter = painterResource(drawableId),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp) // Match the size of the card
                .padding(16.dp) // Add padding to center the image
        )
    }
}

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        color = Color(0xff6d6f77),
        lineHeight = 1.36.em,
        style = MaterialTheme.typography.body2.copy(fontSize = 14.sp), // Use body2 for smaller text
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp) // Adjust top padding for smaller text
    )
}

@Preview
@Composable
fun TipeMyPetsItemPreview() {
    TipeMyPetsItem(Modifier.fillMaxWidth())
}
