package com.example.bulbulapp.navigation

sealed class Screen (val route: String){
    data object SplashScreen : Screen("splashscreen")
    data object OnBoarding : Screen("onboarding")
    data object Home : Screen("home")
    data object MyPets : Screen("mypets")
    data object Blog : Screen("blog")
    data object Layanan : Screen("layanan")
    data object Produk : Screen("produk")

}
