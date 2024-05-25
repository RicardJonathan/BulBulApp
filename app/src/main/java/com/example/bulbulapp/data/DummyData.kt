package com.example.bulbulapp.data

import com.example.bulbulapp.R
import com.example.bulbulapp.model.BeratBadan
import com.example.bulbulapp.model.MyPets
import com.example.bulbulapp.model.Profile

object DummyData{
    val listProfile = listOf(
        Profile(
            id = 1,
            name = "Made",

            photo = R.drawable.user
        ),
    )
    val listMyPets = listOf(
        MyPets(
            id = 1,
            photo = R.drawable.pet1

        ),
        MyPets(
            id = 2,
            photo = R.drawable.bulbulpet1 // Add more items as needed
        ),
    )
    val listBeratBadan = listOf(
        BeratBadan(
            id = 1,
            berat = 4
        ),
        BeratBadan(
            id = 2,
            berat = 6
        ),
        BeratBadan(
            id = 3,
            berat = 8
        )
    )
}