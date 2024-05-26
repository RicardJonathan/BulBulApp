package com.example.bulbulapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bulbulapp.model.BlogRowItem
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TagRow(tag: String) {
    Surface(
        color = Color(0xFFFFB3A3),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(end = 8.dp) // Add space between tags
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = tag,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BlogPostRow(
    blogRowItem: BlogRowItem,
    tags: List<String>,
    onClick: () -> Unit // Handle card click
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 2.dp,
        shape = (RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(blogRowItem.gambar),
                    contentDescription = "Blog Image",
                    modifier = Modifier
                        .size(width = 100.dp, height = 80.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.Bottom)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(35.dp)
                            .padding(5.dp)
                    ) {
                        tags.forEach { tag ->
                            TagRow(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = blogRowItem.judul,
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                    Row(
                        modifier = Modifier
                            .height(15.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.RemoveRedEye,
                            contentDescription = "Read time",
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = blogRowItem.waktuBaca,
                            style = MaterialTheme.typography.caption,
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = blogRowItem.konten.lines().take(2).joinToString("\n"),
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(2.dp))
            val primaryColor = Color(0xFFFF8066)
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("Detail Informasi", color = Color.White, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BlogRowList(blogRowItems: List<BlogRowItem>) {
    Column {
        blogRowItems.forEach { blogRowItem ->
            BlogPostRow(
                blogRowItem = blogRowItem,
                tags = blogRowItem.tagsRow,
                onClick = {}
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Preview
@Composable
fun PreviewBlogRowList() {
    //BlogRowList()
}
