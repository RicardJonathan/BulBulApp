package com.example.bulbulapp

sealed class Screen(val route: String){
    data object Splash: Screen("splash")
    data object Home: Screen("home")
    data object Login: Screen("login")
}
