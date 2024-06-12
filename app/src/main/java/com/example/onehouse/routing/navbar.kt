package com.example.onehouse.Routing

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.onehouse.page.Explore
import com.example.onehouse.page.Favorite
import com.example.onehouse.page.Home
import com.example.onehouse.page.Profile
import com.example.onehouse.R
import com.example.onehouse.page.component.home.kategori.navigate.daftarApartment
import com.example.onehouse.page.component.home.kategori.navigate.daftarRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarTanah
import com.example.onehouse.page.component.home.kategori.navigate.daftarVilla
import com.navbar_explore.Routing.navItem
import com.navbar_explore.Routing.screen
import com.example.onehouse.SignIn
import com.example.onehouse.Register

@Composable
fun Navbar(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {
            NavBottomBar(navController)
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = "signInScreen",
            modifier = modifier.padding(contentPadding)
        ) {
            // SignIn and Register
            composable("signInScreen") {
                SignIn(navController = navController)
            }
            composable("register") {
                Register(navController = navController)
            }

            // Navbar and its screens
            composable("home") {
                Navbar(navController = navController)
            }
            composable(screen.Home.route) {
                Home(navController = navController)
            }
            composable(screen.Explore.route) {
                Explore()
            }
            composable(screen.Favorite.route) {
                Favorite()
            }
            composable(screen.Chat.route) {
                // Chat()
            }
            composable(screen.Profile.route) {
                Profile()
            }

            // Home categories
            composable(screen.daftarRumah.route) {
                daftarRumah(navController)
            }
            composable(screen.daftarApartment.route) {
                daftarApartment(navController = navController)
            }
            composable(screen.daftarVilla.route) {
                daftarVilla(navController = navController)
            }
            composable(screen.daftarTanah.route) {
                daftarTanah(navController = navController)
            }
        }
    }
}

@Composable
fun NavBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.contentColorFor(Color(0xff121212)),
        windowInsets = WindowInsets(bottom = 100)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navItem = listOf(
            navItem(
                title = stringResource(id = R.string.homescreen),
                icon = R.drawable.ic_home,
                screen = screen.Home,
            ),
            navItem(
                title = stringResource(id = R.string.homeexplore),
                icon = R.drawable.ic_explore,
                screen = screen.Explore,
            ),
            navItem(
                title = stringResource(id = R.string.homefavorite),
                icon = R.drawable.ic_fav,
                screen = screen.Favorite,
            ),
            navItem(
                title = stringResource(id = R.string.homechat),
                icon = R.drawable.ic_chat,
                screen = screen.Chat,
            ),
            navItem(
                title = stringResource(id = R.string.homeprofile),
                icon = R.drawable.ic_prof,
                screen = screen.Profile,
            ),
        )
        navItem.map { item ->
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
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = Color.Black,
                        modifier = Modifier.size(size = 25.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title, style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    )
                }
            )
        }
    }
}
