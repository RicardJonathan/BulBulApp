package com.example.bulbulapp


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bulbulapp.data.BlogPostRow
import com.example.bulbulapp.model.BlogRowItem
import androidx.compose.ui.unit.sp

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
    onClick: () -> Unit, // Handle card click
    modifier: Modifier = Modifier // New parameter for modifier
) {
    Card(
        modifier = modifier
            .width(500.dp)
            .height(250.dp),
        elevation = 2.dp,
        shape = (RoundedCornerShape(10.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
                .width(300.dp)
        ) {
            Row(
                modifier = Modifier
                    .width(360.dp)
            ) {
                Image(
                    painter = painterResource(blogRowItem.gambar),
                    contentDescription = "Blog Image",
                    modifier = Modifier
                        .size(width = 100.dp, height = 95.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
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
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = blogRowItem.judul,
                        style = MaterialTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                    Row(
                        modifier = Modifier
                            .height(20.dp)
                            .width(100.dp)
                            .align(AbsoluteAlignment.Left)
                    ) {
                        Icon( modifier = Modifier.size(13.dp),
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Read time",
                            tint = Color.Gray,

                            )
                        Spacer(modifier = Modifier.width(5.dp) .align(Alignment.CenterVertically))
                        Text(
                            text = blogRowItem.waktuBaca,
                            style = MaterialTheme.typography.caption,
                            color = Color.Gray,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp

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
                color = Color.Gray,
                fontSize = 12.sp

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
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(blogRowItems.take(4)) { blogRowItem -> // Ambil hanya 4 item
            BlogPostRow(
                blogRowItem = blogRowItem,
                tags = blogRowItem.tagsRow,
                onClick = { /* Handle click */ },
                modifier = Modifier.padding(start = 5.dp, end = 30.dp)
            )
        }
    }
}

@Composable
fun rekomendasisection () {
    Row(
        horizontalArrangement = Arrangement.spacedBy(88.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Rekomendasi",
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
                .height(28.dp),
                // Latar belakang berwarna dengan sudut membulat
            contentAlignment = Alignment.Center // Menyelaraskan teks ke tengah
        ) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(28.dp), // Latar belakang berwarna dengan sudut membulat
                contentAlignment = Alignment.Center // Menyelaraskan teks ke tengah
            ) {
                ClickableText(
                    text = AnnotatedString("Lihat Lainnya"),
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFFFF8066),
                        fontWeight = FontWeight.SemiBold,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }
    }
}





@RequiresApi(Build.VERSION_CODES.M)
@Preview
@Composable
fun PreviewBlogRowList() {
    BlogRowList(blogRowItems = BlogPostRow.BlogRowItems)
    rekomendasisection ()
}
