package com.example.onehouse.routing


import ChatScreen
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
import com.example.onehouse.page.component.home.kategori.detailKategori.detailApartment
import com.example.onehouse.page.component.home.kategori.detailKategori.detailRumah
import com.example.onehouse.page.component.home.kategori.detailKategori.detailTanah
import com.example.onehouse.page.component.home.kategori.detailKategori.detailVilla
import com.example.onehouse.page.component.home.kategori.navigate.daftarApartment
import com.example.onehouse.page.component.home.kategori.navigate.daftarRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarTanah
import com.example.onehouse.page.component.home.kategori.navigate.daftarVilla
import com.example.onehouse.page.component.profile.navigate.EditProfile
import com.example.onehouse.routing.screen

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
        composable(screen.ChatScreen.route) {
             ChatScreen()
        }
        composable(screen.Profile.route) {
            Profile(navController = navController)
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

        composable(
            screen.detailRumah.route + "/{rumahId}",
            arguments = listOf(navArgument("rumahId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            detailRumah(
                navController = navController,
                rumahId = navBackStackEntry.arguments?.getInt("rumahId")!!
            )
        }
        composable(
            screen.detailApart.route + "/{apartId}",
            arguments = listOf(navArgument("apartId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            detailApartment(
                navController = navController,
                ApartId = navBackStackEntry.arguments?.getInt("apartId")!!
            )
        }

        composable(
            screen.detailVilla.route + "/{villaId}",
            arguments = listOf(navArgument("villaId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            detailVilla(
                navController = navController,
                VillaId = navBackStackEntry.arguments?.getInt("villaId")!!
            )
        }

        composable(
            screen.detailTanah.route + "/{tanahId}",
            arguments = listOf(navArgument("tanahId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            detailTanah(
                navController = navController,
                TanahId = navBackStackEntry.arguments?.getInt("tanahId")!!
            )
        }
        // Profile
        composable(
            "editProfile/{profilId}",
            arguments = listOf(navArgument("profilId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            EditProfile(
                navController = navController,
                profilId = navBackStackEntry.arguments?.getInt("profilId")
            )
        }
    }
}
