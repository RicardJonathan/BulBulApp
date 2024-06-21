package com.example.bulbulapp.model

data class ProdukListItem(
    val productId: Int,
    val productImage: Int,
    val productTags: String,
    val productName: String,
    val productAbout: String,
    val productInfo: Map<String, String>,
    val productNutritionalContent: Map<String, String>,
    val productIngredients: String,
    val additionalInfo: String,
    val recommendations: List<RekomendasiTokoItem>
)