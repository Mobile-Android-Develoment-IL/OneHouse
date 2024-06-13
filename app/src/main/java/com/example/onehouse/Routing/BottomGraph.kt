package com.example.onehouse.Routing

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onehouse.page.Explore
import com.example.onehouse.page.Favorite
import com.example.onehouse.page.Home
import com.example.onehouse.page.Profile
import com.example.onehouse.page.component.home.kategori.navigate.daftarApartment
import com.example.onehouse.page.component.home.kategori.navigate.daftarRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarTanah
import com.example.onehouse.page.component.home.kategori.navigate.daftarVilla
import com.navbar_explore.Routing.screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = screen.Home.route) {
        composable(route = screen.Home.route) {
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