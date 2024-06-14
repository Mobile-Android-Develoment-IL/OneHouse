package com.example.onehouse.routing

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.onehouse.page.Explore
import com.example.onehouse.page.Favorite
import com.example.onehouse.page.Home
import com.example.onehouse.page.Profile
import com.example.onehouse.page.component.home.kategori.detailKategori.DetailRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarApartment
import com.example.onehouse.page.component.home.kategori.navigate.daftarRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarTanah
import com.example.onehouse.page.component.home.kategori.navigate.daftarVilla

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

        composable("detailRumah/{rumahId}",
            arguments = listOf(navArgument("rumahId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val rumahId = backStackEntry.arguments?.getInt("rumahId")
            if (rumahId != null) {
                DetailRumah(navController, rumahId)
            }
        }
    }
}