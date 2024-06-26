package com.example.onehouse.page.component.home.kategori.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onehouse.page.component.home.kategori.model.MdaftarRumah
import com.example.onehouse.page.component.home.kategori.model.MdaftarTanah

@Composable
fun ListdaftarTanah(
    modifier: Modifier = Modifier,
    tanah: MdaftarTanah,
    navController : NavController
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(3.dp)
            .clickable {
                navController.navigate("detailTanah/${tanah.id}")
            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = tanah.gambar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 100.dp, height = 120.dp)
            )
            Text(text = tanah.titletanah)
            Spacer(modifier = Modifier.height(2.dp))
            Row {
                Image(painter = painterResource(id = tanah.iconlok), contentDescription = "map", modifier = Modifier.size(15.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = tanah.alamattanah)
            }
            Text(text = tanah.hrgtanah)
        }
    }
}
