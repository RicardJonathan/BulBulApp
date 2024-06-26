package com.example.movieapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bulbulapp.BlogDetailsScreen
import com.example.bulbulapp.HomeScreen
import com.example.bulbulapp.ListMyPetScreen
import com.example.bulbulapp.Pet
import com.example.bulbulapp.ProductDetailsScreen
import com.example.bulbulapp.R
import com.example.bulbulapp.navigation.NavigationItem
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.profile.EditAccountContent
import com.example.bulbulapp.profile.HapusAkunOverlay
import com.example.bulbulapp.profile.LogoutOverlay
import com.example.bulbulapp.profile.NotificationSettingsScreen
import com.example.bulbulapp.profile.ProfileScreen
import com.example.bulbulapp.screen.BlogScreen
import com.example.bulbulapp.screen.CreateMyPetContent
import com.example.bulbulapp.screen.DetailPetsScreen
import com.example.bulbulapp.screen.DetailScreenLayanan
import com.example.bulbulapp.screen.GantiPasswordSuksesScreen
import com.example.bulbulapp.screen.LayananScreen
import com.example.bulbulapp.screen.LoginScreen
import com.example.bulbulapp.screen.OnBoardingScreen
import com.example.bulbulapp.screen.PasswordChangeScreen
import com.example.bulbulapp.screen.ProdukScreen
import com.example.bulbulapp.screen.RegistrationScreen
import com.example.bulbulapp.screen.SplashScreen
import com.example.bulbulapp.screen.WeightGrafikScreen

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BulBulApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
                // Add top bar content here if needed
            }
        },
        bottomBar = {
            if (currentRoute in listOf(
                    Screen.Home.route,
                    Screen.Blog.route,
                    Screen.Layanan.route,
                    Screen.CreateMyPetscreen.route,
                    Screen.Produk.route
                )) {
                BottomBar(navController)
            }
        },
        modifier = modifier.fillMaxWidth()
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.SplashScreen.route) {
                SplashScreen(navController = navController)
            }
            composable(Screen.OnBoarding.route) {
                OnBoardingScreen(navController = navController)
            }
            composable(Screen.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
            composable(Screen.RegisterScreen.route) {
                RegistrationScreen(navController = navController)
            }
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screen.CreateMyPetscreen.route) {
                CreateMyPetContent(navController = navController)
            }
            composable(Screen.Blog.route) {
                BlogScreen(navController = navController)
            }
            composable(
                route = "blogDetails/{blogPostId}",
                arguments = listOf(navArgument("blogPostId") { type = NavType.IntType })
            ) { backStackEntry ->
                val blogPostId = backStackEntry.arguments?.getInt("blogPostId") ?: return@composable
                BlogDetailsScreen(blogPostId = blogPostId, navController = navController)
            }
            composable(Screen.Layanan.route) {
                LayananScreen(navController = navController)
            }

            composable(
                route = "detailScreenLayanan/{serviceId}",
                arguments = listOf(navArgument("serviceId") { type = NavType.IntType })
            ) { backStackEntry ->
                val serviceId = backStackEntry.arguments?.getInt("serviceId") ?: return@composable
                DetailScreenLayanan(navController = navController, serviceId = serviceId)
            }

            composable(Screen.ProfileScreen.route) {
                ProfileScreen(navController = navController)
            }
            composable(Screen.EditAkunScreen.route) {
                EditAccountContent(navController = navController, modifier = Modifier)
            }
            composable(Screen.NotificationSettingsScreen.route) {
                NotificationSettingsScreen(navController = navController)
            }
            composable(Screen.LogoutOverlay.route) {
                LogoutOverlay(
                    onConfirm = {},
                    onCancel = { navController.navigateUp() }
                )
            }
            composable(Screen.HapusAkunOverlay.route) {
                HapusAkunOverlay(
                    onConfirm = {},
                    onCancel = { navController.navigateUp() }
                )
            }
            composable(
                route = Screen.ProductDetails.route,
                arguments = listOf(navArgument("productId") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: return@composable
                ProductDetailsScreen(productId = productId, navController = navController)
            }
            composable(Screen.Produk.route) {
                ProdukScreen(navController = navController) {
                }
            }
            composable(Screen.ListMyPetScreen.route) {
                val pets = listOf(
                    Pet("BulBul", "1 tahun", "3 kg", R.drawable.bulbulpet1),
                    Pet("BulBul 2", "1 tahun", "3 kg", R.drawable.bulbulpet2)
                )
                ListMyPetScreen(pets = pets, navController = navController)
            }
            composable(
                route = Screen.DetailPetsScreen.route + "/{petName}",
                arguments = listOf(navArgument("petName") { type = NavType.StringType })
            ) { backStackEntry ->
                val petName = backStackEntry.arguments?.getString("petName")
                DetailPetsScreen(navController = navController, petName = petName)
            }
            composable(Screen.WeightGrafikScreen.route) {
                WeightGrafikScreen(navController = navController)
            }
            composable(Screen.PasswordChangeScreen.route) {
                PasswordChangeScreen(navController = navController)
            }
            composable(Screen.PasswordChangeSuccessScreen.route) {
                GantiPasswordSuksesScreen(navController = navController)
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = painterResource(id = R.drawable.home),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_MyPets),
                icon = painterResource(id = R.drawable.navbarpet),
                screen = Screen.ListMyPetScreen
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_blog),
                icon = painterResource(id = R.drawable.blog),
                screen = Screen.Blog
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_layanan),
                icon = painterResource(id = R.drawable.services),
                screen = Screen.Layanan
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_produk),
                icon = painterResource(id = R.drawable.productnav),
                screen = Screen.Produk
            )
        )

        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(painter = item.icon, contentDescription = item.title, modifier = Modifier.size(24.dp)) },
                label = { Text(text = item.title) }
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun BulBulAppPrev() {
    BulBulApp()
}