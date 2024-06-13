package com.example.onehouse.page.component.home.kategori.list

import android.widget.GridLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.onehouse.R
import com.example.onehouse.page.component.home.kategori.data.data
import com.example.onehouse.page.component.home.kategori.data.data.dtRumah
import com.example.onehouse.page.component.home.kategori.model.MdaftarApartment
import com.example.onehouse.page.component.home.kategori.model.MdaftarRumah
import com.example.onehouse.page.component.home.kategori.model.MdaftarTanah

@Composable
fun ListdaftarTanah(
    modifier: Modifier = Modifier,
    tanahh: MdaftarTanah
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = tanahh.gambar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 100.dp, height = 170.dp)
        )
    }
}