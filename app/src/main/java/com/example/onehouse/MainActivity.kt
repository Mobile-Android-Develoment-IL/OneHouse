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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.onehouse.page.component.home.kategori.navigate.daftarApartment
import com.example.onehouse.page.component.home.kategori.navigate.daftarRumah
import com.example.onehouse.page.component.home.kategori.navigate.daftarTanah
import com.example.onehouse.page.component.home.kategori.navigate.daftarVilla
import com.example.onehouse.repository.AuthRepository
import com.example.onehouse.routing.Navbar
import com.example.onehouse.ui.theme.OneHouseTheme
import com.example.onehouse.viewmodel.AuthViewModel
import com.example.onehouse.viewmodel.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    private lateinit var authViewModel: AuthViewModel
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val authRepository = AuthRepository(FirebaseAuth.getInstance())
        val authViewModelFactory = AuthViewModelFactory(authRepository)
        authViewModel = ViewModelProvider(this, authViewModelFactory)[AuthViewModel::class.java]

        setContent {
            val navController = rememberNavController()
            OneHouseTheme{
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    NavHost(navController = navController, startDestination = "signIn") {
                        composable("signIn") {
                            SignIn(navController = navController, authViewModel = authViewModel)
                        }
                        composable("register") {
                            Register(navController = navController, authViewModel = authViewModel)
                        }
                        composable("homeNav") {
                            Navbar()
                        }
                    }
                }
            }
        }
    }
}