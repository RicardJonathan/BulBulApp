package com.example.bulbulapp.data

import com.example.bulbulapp.R
import com.example.bulbulapp.model.BlogRowItem

object BlogPostRow {

    val BlogRowItems = listOf(
        BlogRowItem(
            judul = "Pahami kucingmu melalui bahasa tubuh mereka",
            gambar = R.drawable.rekomblog,
            konten = "Sebagai pawrents yang baik, akan lebih menyenangkan jika kamu mengetahui....",
            waktuBaca = "2 menit",
            tagsRow = listOf("Edukasi", "Kucing")
        ),
        BlogRowItem(
            judul = "3 Bahan Makanan ini penting untuk kucingmu",
            gambar = R.drawable.rekomblog2,
            konten = "Tahukah kamu, Kucing juga perlu diperhatikan nutrisi makanannya....",
            waktuBaca = "2 menit",
            tagsRow = listOf("Edukasi", "Kucing")
        ),
        BlogRowItem(
            judul = "Makanan Yang Terbaik Untuk Kucingmu",
            gambar = R.drawable.blogdetails,
            konten = "Tahukah kamu, Kucing juga perlu diperhatikan nutrisi makanannya....",
            waktuBaca = "2 menit",
            tagsRow = listOf("Tips", "Kucing")
        ),
        BlogRowItem(
            judul = "3 Aksesoris yang aman untuk Anjingmu",
            gambar = R.drawable.ilustrasiblog2,
            konten = "Tahukah kamu, Aksesoris untuk anabulmu adalah pilihan yang...",
            waktuBaca = "2 menit",
            tagsRow = listOf("Tips", "Anjing")
        )
    )
}