package com.example.onehouse.page.component.home.kategori.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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