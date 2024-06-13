package com.example.onehouse

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onehouse.Routing.Navbar
import com.example.onehouse.page.component.home.kategori.navigate.daftarApartment
import com.example.onehouse.page.component.home.kategori.navigate.daftarRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarTanah
import com.example.onehouse.page.component.home.kategori.navigate.daftarVilla
import com.example.onehouse.ui.theme.OneHouseTheme
import com.navbar_explore.Routing.screen

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            OneHouseTheme{
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    NavHost(navController = navController, startDestination = "masuk") {
                        composable("masuk") {
                            SignIn(navController = navController)
                        }
                        composable("daftar") {
                            Register(navController = navController)
                        }
                        composable("homeNav") {
                            Navbar()
                        }
                        composable("daftarRumah") {
                            daftarRumah(navController)
                        }
                        composable("daftarApartment") {
                            daftarApartment(navController = navController)
                        }
                        composable("daftarVilla") {
                            daftarVilla(navController = navController)
                        }
                        composable("daftarTanah") {
                            daftarTanah(navController = navController)
                        }
                    }

                }
            }
        }
    }
}
