package com.example.onehouse.page.component.home.kategori.navigate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.page.component.home.kategori.data.data
import com.example.onehouse.page.component.home.kategori.list.ListdaftarRumah
import com.example.onehouse.page.component.home.kategori.model.MdaftarRumah

@Composable
fun daftarRumah(
    navController: NavController,
    modifier: Modifier = Modifier,
    rumah: List<MdaftarRumah> = data.dtRumah
) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xf55AD9B)),
            contentAlignment = Alignment.CenterStart
        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Text(
                text = "Daftar Rumah",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        LazyVerticalGrid(
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Adaptive(150.dp),
            modifier = modifier.fillMaxSize(),
        ) {
            items(rumah, key = { it.id }) {
                ListdaftarRumah(navController = navController, rumah = it)
            }
        }
    }
}
