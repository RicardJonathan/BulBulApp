package com.example.bulbulapp

sealed class Screen(val route: String){
    data object Splash: Screen("splash")
    data object OnBoarding: Screen("onboarding")
    data object HomeLoginScreen: Screen("home login screen")
    data object Login: Screen("login")
    data object Register: Screen("register_screen")
    data object Verification: Screen("verification_screen")
    data object VerificationSuccess: Screen("verification_success_screen")

    data object GantiPassword: Screen("ganti_password")

    data object GantiPasswordSukses: Screen("ganti_password_sukses")



}
