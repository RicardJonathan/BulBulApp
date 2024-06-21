package com.example.bulbulapp.data

import BlogPostItem
import com.example.bulbulapp.R


object BlogPostData {

    val BlogPostItems = listOf(
        BlogPostItem(
            id = 0,
            title = "Cara Mengetahui Berat Badan Ideal untuk Kucing",
            imageResourceId = R.drawable.blogdetails,
            content = "Tahukah kamu, kucing juga perlu mendapatkan berat badan ideal? Masalahnya pemilik hewan....",
            readTime = "2 menit",
            tags = listOf("Edukasi", "Kucing")
        ),
        BlogPostItem(
            id = 1,
            title = "Tips Merawat Bulu Anjing Tetap Lembut & Bersih",
            imageResourceId = R.drawable.ilustrasiblog2,
            content = "Pawrents pasti kesulitan untuk menjaga kebersihan bulu anjing kesayanganmu....",
            readTime = "2 menit",
            tags = listOf("Tips", "Anjing")
        ),
        BlogPostItem(
            id = 2,
            title = "Rekomendasi Layanan Konsultasi Untuk Anabul",
            imageResourceId = R.drawable.ilustrasiblog,
            content = "Konsultasi secara online memudahkan para pawrents untuk mengenali tanda awal....",
            readTime = "2 menit",
            tags = listOf("Layanan", "Kucing", "Anjing")
        )
    )

    val BlogPostDetails = listOf(
        BlogPostItem(
            id = 0,
            title = "Cara Mengetahui Berat Badan Ideal untuk Kucing",
            imageResourceId = R.drawable.blogdetails,
            content = "Tahukah kamu, kucing juga perlu mendapatkan berat badan ideal? Masalahnya pemilik hewan peliharaan kerap memanjakan kucingnya dengan memberikan makanan yang berlebihan. Sebagian besar kucing rumahan dewasa biasanya memiliki berat sekitar 3,6-4,5 kilogram, meskipun ini dapat bervariasi berdasarkan ras, umur, dan jenis kelamin. Seekor kucing Siam beratnya hanya 2,2 kilogram, sedangkan Maine Coon bisa beratnya 11 kilogram dan ini tergolong sehat. Penambahan berat badan kucing biasanya tergantung pada jenis dan jumlah makanan yang diberikan, serta kebosanan si kucing. Kalau kucing merasa bosan, kucing akan berpikir untuk makan.",
            readTime = "5 menit",
            tags = listOf("Edukasi", "Kucing")
        ),
        BlogPostItem(
            id = 1,
            title = "Tips Merawat Bulu Anjing Tetap Lembut & Bersih",
            imageResourceId = R.drawable.ilustrasiblog2,
            content = "Bulu anjing yang lembut dan bersih adalah tanda dari kesehatan yang baik. Namun, merawat bulu anjing tidaklah mudah dan memerlukan perawatan yang teratur. Berikut adalah beberapa tips untuk menjaga bulu anjing tetap lembut dan bersih: \n- Mandikan anjing secara teratur dengan sampo yang sesuai untuk jenis bulu mereka. \n- Sisir bulu anjing setiap hari untuk menghilangkan kusut dan rambut mati. \n- Berikan makanan yang mengandung nutrisi yang baik untuk kesehatan bulu.",
            readTime = "5 menit",
            tags = listOf("Tips", "Anjing")
        ),
        BlogPostItem(
            id = 2,
            title = "Rekomendasi Layanan Konsultasi Untuk Anabul",
            imageResourceId = R.drawable.ilustrasiblog,
            content = "Konsultasi secara online memudahkan para pawrents untuk mengenali tanda awal masalah kesehatan pada anjing atau kucing mereka. Layanan ini dapat memberikan informasi yang berharga tentang perawatan kesehatan hewan peliharaan, diagnosis penyakit, dan rekomendasi perawatan lebih lanjut dari dokter hewan yang berpengalaman.",
            readTime = "5 menit",
            tags = listOf("Layanan", "Kucing", "Anjing")
        )
    )
}
