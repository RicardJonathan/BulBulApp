package com.example.bulbulapp.navigation

sealed class Screen (val route: String) {
    data object SplashScreen : Screen("splashscreen")
    data object OnBoarding : Screen("onboarding")
    data object LoginScreen : Screen("loginscreen")
    data object RegisterScreen : Screen("registerscreen")
    data object Home : Screen("home")
    data object CreateMyPtscreen : Screen("create_my_pet_screen")
    data object Blog : Screen("blog")
    data object BlogDetail : Screen("blogDetail/{blogPostId}") {
        fun createRoute(blogPostId: Int): String = "blogDetail/$blogPostId"
    }
    data object Layanan : Screen("layanan")
    data object Produk : Screen("produk")
    data object ProductDetails : Screen("productDetails/{productId}") {
        fun createRoute(productId: Int): String = "productDetails/$productId"
    }
    data object ProfileScreen : Screen("profilescreen")
    data object EditAkunScreen : Screen("editakunscreen")
    data object NotificationSettingsScreen : Screen(" NotificationSettingsScreen")
    data object LogoutOverlay : Screen(" LogoutOverlay")
    data object HapusAkunOverlay : Screen(" HapusAkunOverlay")

}
