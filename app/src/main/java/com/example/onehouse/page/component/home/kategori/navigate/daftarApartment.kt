package com.example.onehouse.page.component.home.kategori.navigate

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun daftarApartment(modifier: Modifier = Modifier,
                navController: NavController,
                ) {
    Column (modifier = modifier){
        Text(text = "Daftar Apartment")
    }
}