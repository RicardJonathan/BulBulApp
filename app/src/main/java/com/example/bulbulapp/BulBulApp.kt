package com.example.movieapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bulbulapp.HomeScreen
import com.example.bulbulapp.R
import com.example.bulbulapp.navigation.NavigationItem
import com.example.bulbulapp.navigation.Screen
import com.example.bulbulapp.screen.BlogScreen
import com.example.bulbulapp.screen.MyPetsScreen

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

            }
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier.fillMaxWidth() // Menyesuaikan dengan kiri dan kanan layar
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }
            composable(Screen.MyPets.route) {
                MyPetsScreen()
            }
            composable(Screen.Blog.route) {
                BlogScreen()
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
                icon = painterResource(id = R.drawable.home), // Replace with your custom drawable resource ID
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_mypets),
                icon = painterResource(id = R.drawable.navbarpet), // Replace with your custom drawable resource ID
                screen = Screen.MyPets
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_blog),
                icon = painterResource(id = R.drawable.blog), // Replace with your custom drawable resource ID
                screen = Screen.Blog
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_layanan),
                icon = painterResource(id = R.drawable.services), // Replace with your custom drawable resource ID
                screen = Screen.Layanan
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_produk),
                icon = painterResource(id = R.drawable.productnav), // Replace with your custom drawable resource ID
                screen = Screen.Produk
            )
        )
        navigationItems.map { item ->
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
                icon = { Icon(painter = item.icon, contentDescription = item.title, modifier = Modifier.size(24.dp)) }, // Set icon size here
                label = { Text(text = item.title) }
            )
        }
    }
}

@Composable
private fun BackButton(navController: NavController, iconResId: Int, contentDescription: String) {
    val painter: Painter = painterResource(id = iconResId)
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier
            .clickable {
                navController.popBackStack()
            }
            .padding(16.dp)
            .size(24.dp) // Set back button icon size here
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun BulBulAppPrev() {
    BulBulApp()
}
