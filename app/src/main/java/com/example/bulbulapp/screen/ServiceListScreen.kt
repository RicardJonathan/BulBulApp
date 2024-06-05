
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.component.CardlayananItem
import com.example.bulbulapp.data.DummyData

@Composable
fun ServiceListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Layanan",
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
        content = { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 8.dp) // Apply padding here
            ) {
                items(DummyData.listLayanan) { layanan ->
                    CardlayananItem(
                        layanan = layanan,
                        onItemClicked = { clickedLayanan ->
                            // Handle item click here

                        }
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ServiceListScreenPreview() {
    val navController = rememberNavController()
    ServiceListScreen(navController)
}
