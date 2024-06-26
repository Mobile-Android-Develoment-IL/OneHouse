package com.example.onehouse.page.component.home.kategori.detailKategori

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.onehouse.R
import com.example.onehouse.page.component.home.kategori.data.data
import com.example.onehouse.page.component.home.kategori.model.MdaftarRumah

@Composable
fun detailRumah(
    navController: NavController,
    rumahId: Int
) {
    val listRumah = data.dtRumah.filter { rumah ->
        rumah.id == rumahId
    }
    Column(
        modifier = Modifier
    ) {
        detailRumahContent(navController = navController, listRumah = listRumah)
    }


}

@Composable
private fun detailRumahContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    listRumah: List<MdaftarRumah>,
) {
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
                text = "Detail Rumah",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = listRumah[0].gambar)
                    .build(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(height = 300.dp, width = 350.dp),
                contentDescription = "detail rumah"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = listRumah[0].title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(10.dp))
            fasilitasRumah()
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.padding(start = 200.dp)) {
                Text(
                    text = listRumah[0].hrgrmh,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Image(
                    painter = painterResource(id = listRumah[0].iconlok),
                    contentDescription = "map",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = listRumah[0].alamat, fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier= Modifier.padding(start = 220.dp)) {
                Button(
                    onClick = {  },
                    modifier = Modifier.width(100.dp)
                ) {
                    Text(text = "Beli", fontSize = 16.sp)
                }
            }


        }


    }

}


@Composable
fun fasilitasRumah(modifier: Modifier = Modifier) {
    val facilities = listOf(
        "3 Kamar Tidur" to R.drawable.kmtidur,
        "2 Kamar Mandi" to R.drawable.kmmandi,
        "Dapur" to R.drawable.dapur,
        "Garasi Mobil" to R.drawable.grg
    )

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(8.dp)
            .width(330.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Fasilitas Rumah",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            for (i in facilities.indices step 2) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    facilities[i].let { (facility, iconRes) ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = iconRes),
                                contentDescription = facility,
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = facility, fontSize = 18.sp)
                        }
                    }
                    if (i + 1 < facilities.size) {
                        facilities[i + 1].let { (facility, iconRes) ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(id = iconRes),
                                    contentDescription = facility,
                                    tint = Color.Black,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = facility, fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}
