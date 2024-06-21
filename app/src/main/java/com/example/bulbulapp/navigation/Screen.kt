package com.example.bulbulapp.navigation

sealed class Screen(val route: String) {
    data object SplashScreen : Screen("splashscreen")
    data object OnBoarding : Screen("onboarding")
    data object LoginScreen : Screen("loginscreen")
    data object RegisterScreen : Screen("registerscreen")
    data object Home : Screen("home")
    data object CreateMyPtscreen : Screen("create_my_pet_screen")
    data object Blog : Screen("blog")
    data object Layanan : Screen("layanan")
    data object Produk : Screen("produk")
    data class BlogDetails(val blogPostId: Int) : Screen("blogDetails/$blogPostId") {
        companion object {
            fun createRoute(blogPostId: Int): String = "blogDetails/$blogPostId"
        }
    }
    data object ProductDetails : Screen("productDetails/{productId}") {
        fun createRoute(productId: Int): String = "productDetails/$productId"
    }
    data object ProfileScreen : Screen("profilescreen")
    data object EditAkunScreen : Screen("editakunscreen")
    data object NotificationSettingsScreen : Screen("notificationsettingscreen")
    data object LogoutOverlay : Screen("logoutoverlay")
    data object HapusAkunOverlay : Screen("hapusakunoverlay")
}
