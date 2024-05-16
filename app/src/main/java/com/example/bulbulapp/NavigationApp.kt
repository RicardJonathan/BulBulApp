package com.example.bulbulapp

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route){
        composable(Screen.Splash.route){
            SplashScreen(navController = navController)
        }

        composable(Screen.Home.route){

        }
    }
}