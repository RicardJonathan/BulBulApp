package com.example.bulbulapp.data

import com.example.bulbulapp.R
import com.example.bulbulapp.model.OnBoardingItem

object OnBoardingData {

    val onBoardingItems = listOf(
        OnBoardingItem(
            resId = R.raw.ilustrasi1,
            title = "Memantau Hewan Peliharaan",
            description = "Monitoring berat badan dan membantu mengatur aktivitas pets kesayanganmu."
        ),
        OnBoardingItem(
            resId = R.raw.ilustrasi2,
            title = "Kesehatan & Perawatan Hewan Peliharaan",
            description = "Merekomendasikan berbagai hal terkait kesehatan serta perawatan hewan peliharaan."
        ),
    )
}