package com.example.bulbulapp

import VerifyScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(Screen.HomeLoginScreen.route) {
            HomeLoginScreen(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Register.route) {
            RegistrationScreen(navController = navController)
        }
        composable(Screen.Verification.route) {
            VerifyScreen(navController = navController)
        }
        composable(Screen.VerificationSuccess.route) {
            VerifikasiSuksesScreen()
        }
        composable(Screen.GantiPassword.route) {
            PasswordChangeScreen(navController = navController)
        }
        composable(Screen.GantiPasswordSukses.route) {
            GantiPasswordSuksesScreen()
        }
    }
}
