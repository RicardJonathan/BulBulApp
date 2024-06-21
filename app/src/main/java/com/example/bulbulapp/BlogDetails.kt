package com.example.bulbulapp

import BlogPostItem
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.data.BlogPostData
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.data.BlogPostRow

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BlogDetails(blogPostDetail: BlogPostItem, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { navController.navigate(Screen.Blog.route) }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Detail Blog",
                    fontSize = 20.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(2f)
                )
            }
        }

        item {
            // Blog Image
            Image(
                painter = painterResource(id = blogPostDetail.imageResourceId),
                contentDescription = "Blog Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)  // Adjust aspect ratio as needed
                    .padding(horizontal = 16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))  // Add space between image and tags
        }

        item {
            // Tags
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                blogPostDetail.tags.forEach { tag ->
                    AssistChip(
                        onClick = {},
                        label = { Text(tag) },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color(0xFFFFB3A3),
                            labelColor = Color.White
                        )
                    )
                }
            }
        }

        item {
            // Read Time
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.RemoveRedEye,
                    contentDescription = "Read time",
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))  // Add space between icon and text
                Text(
                    text = blogPostDetail.readTime,
                    fontSize = 14.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                    color = Color.Gray
                )
            }
        }

        item {
            // Blog Title
            Text(
                text = blogPostDetail.title,
                fontSize = 18.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp)) // Add space between title and content
        }

        item {
            // Blog Content
            Text(
                text = blogPostDetail.content,
                fontSize = 16.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Justify,  // Set text alignment to justify
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rekomendasi",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.weight(1f))
                ClickableText(
                    text = AnnotatedString("Lihat Lainnya"),
                    onClick = {},
                    modifier = Modifier
                        .weight(0.8f)
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
        item {
            BlogRowList(blogRowItems = BlogPostRow.BlogRowItems)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun PreviewBlogDetailsScreen() {
    val navController = rememberNavController()
    val blogPostId = 0 // Ganti ini sesuai dengan blogPostId yang relevan untuk preview
    BlogDetailsScreen(navController = navController, blogPostId = blogPostId)
}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun BlogDetailsScreen(navController: NavController, blogPostId: Int) {
    val blogPostDetail = BlogPostData.BlogPostDetails.getOrNull(blogPostId)
    blogPostDetail?.let {
        BlogDetails(blogPostDetail = it, navController = navController)
    }
}



