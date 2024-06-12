package com.example.onehouse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.onehouse.Routing.Navbar
import com.example.onehouse.ui.theme.OneHouseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OneHouseTheme {
                val navController = rememberNavController()
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    Navbar(navController = navController)
                }
            }
        }
    }
}
