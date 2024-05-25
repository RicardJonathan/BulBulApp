
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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

@Composable
fun VerifyScreen(navController: NavController) {
    val pinDigits = remember { mutableStateListOf("", "", "", "") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Verifikasi Akun",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color(0xFFFF8066) // Orange color for welcome text
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 17.dp, vertical = 8.dp)
            )
            Text(
                text = "Masukkan 4-digit kode PIN yang telah dikirimkan ke email ",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 18.sp,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp)) // Adding smaller space between the text and the row

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (index in pinDigits.indices) {
                    Box(
                        modifier = Modifier
                            .requiredSize(size = 48.dp)
                            .clip(shape = RoundedCornerShape(6.dp))
                            .background(color = Color.White)
                            .border(
                                border = BorderStroke(1.dp, Color(0xff545f71)),
                                shape = RoundedCornerShape(6.dp)
                            )
                    ) {

                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp)) // Adding smaller space between the row and the buttons
        }

        // Memasukkan kedua tombol di dalam satu Row
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Button(
                onClick = {  },
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF8066) // Warna dalam format hex
                ),
                shape = RoundedCornerShape(4.dp) // Menambahkan shape dengan sudut melengkung
            ) {
                Text("Verifikasi")
            }

            // Mengurangi tinggi spacer agar tombol tidak berjauhan
            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = { /* Handle create new account action */ },
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF8066) // Warna dalam format hex
                ),
                shape = RoundedCornerShape(4.dp) // Menambahkan shape dengan sudut melengkung
            ) {
                Text("Kirim ulang")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerifyScreenPreview() {
    val navController = rememberNavController()
    VerifyScreen(navController = navController)
}
