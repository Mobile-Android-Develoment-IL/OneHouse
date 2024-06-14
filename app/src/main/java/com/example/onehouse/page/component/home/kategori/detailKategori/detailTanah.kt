package com.example.onehouse.page.component.home.kategori.detailKategori

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.onehouse.page.component.home.kategori.data.data
import com.example.onehouse.page.component.home.kategori.model.MdaftarApartment
import com.example.onehouse.page.component.home.kategori.model.MdaftarRumah
import com.example.onehouse.page.component.home.kategori.model.MdaftarTanah

@Composable
fun detailTanah(
    modifier: Modifier = Modifier,
    navController: NavController,
    TanahId: Int
) {
    val listTanah = data.dtTanah.filter { tanah ->
        tanah.id == TanahId
    }
    Column(
        modifier = Modifier
    ) {
        detailTanahContent(navController = navController, listTanah = listTanah)
    }

}

@Composable
fun detailTanahContent(navController: NavController,
                       modifier: Modifier = Modifier,
                       listTanah: List<MdaftarTanah>,) {
    Column(
        modifier = Modifier.padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)

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
                text = "Detail Tanah",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = listTanah[0].gambar)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(height = 300.dp, width = 350.dp),
                contentDescription = "detail tanah"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = listTanah[0].titletanah,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(10.dp))
            fasilitasRumah()
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(start = 200.dp)) {
                Text(
                    text = listTanah[0].hrgtanah,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Image(
                    painter = painterResource(id = listTanah[0].iconlok),
                    contentDescription = "map",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = listTanah[0].alamattanah, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.padding(start = 220.dp)) {
                Button(
                    onClick = { },
                    modifier = Modifier.width(100.dp)
                ) {
                    Text(text = "Beli", fontSize = 16.sp)
                }
            }


        }


    }
}
