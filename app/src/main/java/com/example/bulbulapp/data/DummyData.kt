package com.example.bulbulapp.data

import com.example.bulbulapp.R
import com.example.bulbulapp.model.BeratBadan
import com.example.bulbulapp.model.Grooming
import com.example.bulbulapp.model.Layanan
import com.example.bulbulapp.model.MyPets
import com.example.bulbulapp.model.PetShop
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
        ),
        BeratBadan(
            id = 4,
            berat = 7
        ),
    )
    val listPetShop = listOf(
        PetShop(
            id = 1,
            name = "Makanan Kering",
            description = "Anjing/Kucing",
            photo = R.drawable.product_whiskas,

        ),
        PetShop(
            id = 2,
            name = "Makanan Kering",
            description = "Anjing/Kucing",
            photo = R.drawable.meo,

            ),
        PetShop(
            id = 3,
            name = "Makanan Basah",
            description = "Anjing/Kucing",
            photo = R.drawable.kalung1,

            ),
        PetShop(
            id = 4,
            name = "Makanan Kering",
            description = "Anjing/Kucing",
            photo = R.drawable.product_whiskas,

            ),
    )
    val listGrooming = listOf(
        Grooming(
            id = 1,
            name = "Grooming Lengkap",
            description = "Anjing/Kucing",
            photo = R.drawable.grooming_lengkap
        ),
        Grooming(
            id = 2,
            name = "Grooming Kutu",
            description = "Anjing/Kucing",
            photo = R.drawable.groomingkutu
        ),
        Grooming(
            id = 3,
            name = "Grooming Lengkap",
            description = "Anjing/Kucing",
            photo = R.drawable.grooming_lengkap
        ),
        Grooming(
            id = 4,
            name = "Grooming Lengkap",
            description = "Anjing/Kucing",
            photo = R.drawable.groomingkutu
        ),
        Grooming(
            id = 5,
            name = "Grooming Lengkap",
            description = "Anjing/Kucing",
            photo = R.drawable.grooming_lengkap
        ),
    )

}