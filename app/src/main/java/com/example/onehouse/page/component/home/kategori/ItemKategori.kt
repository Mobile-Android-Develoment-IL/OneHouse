package com.example.onehouse.page.component.home.kategori

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.R


import com.example.onehouse.routing.screen

@Composable
fun Kategori(navController: NavController, modifier: Modifier = Modifier) {
    Column(modifier) {
        ItemKategori(
            listOf(
                MKategori(1, "Rumah", R.drawable.house, screen.daftarRumah.route),
                MKategori(2, "Apartment", R.drawable.apartment, screen.daftarApartment.route),
                MKategori(3, "Villa", R.drawable.villa, screen.daftarVilla.route),
                MKategori(4, "Tanah", R.drawable.tanah, screen.daftarTanah.route)
            ),
            navController
        )
    }
}

@Composable
fun ItemKategori(mkategoris: List<MKategori>, navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        mkategoris.forEach { mkategori ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    navController.navigate(mkategori.route)
                }
            ) {
                Image(
                    painter = painterResource(id = mkategori.iconn),
                    contentDescription = mkategori.namekategori,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = mkategori.namekategori, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}
