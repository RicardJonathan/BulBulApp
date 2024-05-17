package com.example.bulbulapp

sealed class Screen(val route: String){
    data object Splash: Screen("splash")
    data object OnBoarding: Screen("onboarding")
    data object Login: Screen("login")
    data object Home: Screen("home")

}
