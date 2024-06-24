package com.example.bulbulapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.R
import com.example.bulbulapp.data.DummyData
import com.example.bulbulapp.data.LayananListData
import com.example.bulbulapp.model.LayananListItem

@Composable
fun CardlayananItem(
    layanan: LayananListItem,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    androidx.compose.material.Card(
        modifier = modifier
            .padding(20.dp)
            .clickable { onItemClicked(layanan.id) },
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = layanan.photo),
                contentDescription = layanan.name,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = layanan.name,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bintang),
                            contentDescription = "Vector",
                            modifier = Modifier.size(11.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = layanan.rating,
                            color = Color(0xff545f71),
                            style = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = layanan.description,
                    style = TextStyle(fontSize = 12.sp),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = layanan.tag,
                    color = Color.White,
                    style = TextStyle(fontSize = 11.sp),
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color(0xffffa694))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Surface(
                color = Color(0xffff8066),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.clickable { onItemClicked(layanan.id) }
            ) {
                Text(
                    text = "Lihat Layanan",
                    color = Color.White,
                    style = TextStyle(fontSize = 11.sp, fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
                )
            }
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun CardlayananItemPreview() {
//    val layanan = LayananListData.listLayananItems.first()
//    CardlayananItem(
//        layanan = layanan,
//        onItemClicked = {}
//    )
//}
