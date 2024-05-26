package com.example.bulbulapp.model

data class BlogPostItem(
    val title: String,
    val imageResourceId: Int,
    val content: String,
    val readTime: String,
    val tags: List<String>
)