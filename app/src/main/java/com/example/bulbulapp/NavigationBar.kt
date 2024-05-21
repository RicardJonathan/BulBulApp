package com.example.bulbulapp

sealed class NavigationItem(
    val title: String,
    val iconResourceId: Int
) {
    object Home : NavigationItem("Home", R.drawable.home)
    object Chat : NavigationItem("Chat", R.drawable.navbarpet)
    object Profile : NavigationItem("Profile", R.drawable.blog)
    object Settings : NavigationItem("Settings", R.drawable.services)
    object About : NavigationItem("About", R.drawable.productnav)
}