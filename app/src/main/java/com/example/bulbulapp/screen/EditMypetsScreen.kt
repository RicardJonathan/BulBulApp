
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.bulbulapp.R
import com.example.bulbulapp.component.FotoMyPets
import com.example.bulbulapp.component.ItemInputDataHewanSaya
import com.example.bulbulapp.component.KondisiBadanItem
import com.example.bulbulapp.component.TingkatAktivitasItem
import com.example.bulbulapp.component.UkuranBadanItem

@Composable
fun TipeMyPetsItem(tipeKucing: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Tipe My Pets",
            color = Color(0xff6d6f77),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            CustomImage(drawableId = R.drawable.cat)
            Spacer(modifier = Modifier.weight(5f))
            CustomText(text = tipeKucing)
        }
    }
}

@Composable
fun SaveButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xffff8066)
            ),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Simpan Perubahan", color = Color.White)
        }
    }
}

@Composable
fun EditMypetsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Edit",
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
                                .clip(shape = RoundedCornerShape(112.dp))
                                .background(color = Color(0xffeef1f4))
                                .padding(4.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ){ padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            item {
                TipeMyPetsItem("Kucing")
            }
            item {
                FotoMyPets(Modifier.fillMaxWidth())
            }
            item {
                ItemInputDataHewanSaya(Modifier.fillMaxWidth())
            }
            item {
                UkuranBadanItem(Modifier.fillMaxWidth())
            }
            item {
                TingkatAktivitasItem(Modifier.fillMaxWidth())
            }
            item {
                KondisiBadanItem(Modifier.fillMaxWidth())
            }
            item {
                Spacer(modifier = Modifier.height(20.dp)) // Add some space before the button
                SaveButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { /* Handle save action */ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditMypetsScreenPreview() {
    val navController = rememberNavController()
    EditMypetsScreen(navController)
}