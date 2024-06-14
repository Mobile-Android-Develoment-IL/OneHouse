package com.example.onehouse.page.component.home.kategori.detailKategori

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.page.component.home.kategori.data.data

@Composable
fun DetailRumah(navController: NavController, rumahId: Int) {
    val rumah = data.dtRumah.find { it.id == rumahId }

    rumah?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = rumah.gambar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = rumah.title, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Alamat: ${rumah.alamat}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Harga: ${rumah.hrgrmh}")
            Spacer(modifier = Modifier.height(8.dp))
            // Add more details here as needed
        }
    } ?: Text("Rumah tidak ditemukan.")
}