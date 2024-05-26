package com.example.bulbulapp.data

import com.example.bulbulapp.R
import com.example.bulbulapp.model.BlogPostItem

object BlogPostData {

    val BlogPostItems = listOf(
        BlogPostItem(
            title = "Cara Mengetahui Berat Badan Ideal untuk Kucing",
            imageResourceId = R.drawable.blogdetails,
            content = "...",
            readTime = "2 menit",
            tags = listOf("Edukasi", "Kucing")
        ),
        BlogPostItem(
            title = "Tips Merawat Bulu Anjing Tetap Lembut & Bersih",
            imageResourceId = R.drawable.ilustrasiblog2,
            content = "...",
            readTime = "2 menit",
            tags = listOf("Tips", "Anjing")
        ),
        BlogPostItem(
            title = "Rekomendasi Layanan Konsultasi Untuk Anabul",
            imageResourceId = R.drawable.ilustrasiblog,
            content = "...",
            readTime = "2 menit",
            tags = listOf("Layanan", "Kucing", "Anjing")
        ),
    )
}