package com.example.onehouse.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.page.component.home.kategori.MKategori
import com.example.onehouse.page.component.home.kategori.dataKategori
import com.example.onehouse.page.component.home.recomendasi.ItemRekomen
import com.example.onehouse.page.component.home.recomendasi.MRekomendasi
import com.example.onehouse.page.component.home.recomendasi.dataRekomendasi
import com.example.onehouse.page.component.home.terbaru.ItemTerbaru
import com.example.onehouse.page.component.home.terbaru.MTerbaru
import com.example.onehouse.page.component.home.terbaru.dataTerbaru
import com.example.onehouse.R
import com.example.onehouse.page.component.home.kategori.Kategori


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavController,
    kategoris: List<MKategori> = dataKategori.Kategoridt,
    rekomens: List<MRekomendasi> = dataRekomendasi.Rekomendasidt,
    terbarru: List<MTerbaru> = dataTerbaru.Terbarudt
) {
    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
        ) {
        Box (modifier = Modifier.padding(top = 50.dp, start = 160.dp)){
            Text(
                text = "Lokasi", fontSize = 18.sp, fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {},
                active = false,
                onActiveChange = {},
                placeholder = { Text("Search") },
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {}
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 45.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null,
                    modifier = modifier.size(25.dp)
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Kategori", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                ) {
                    item {
                        Kategori(navController = navController)
                    }
                }
            }

            item {
                Text(text = "Rekomendasi", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                ) {
                    items(rekomens, key = { it.id }) {
                        ItemRekomen(mrekomendasi = it) { mrekomendasiId ->
//                             navController.navigate(screen.Detail.route + "/$mrekomendasiId")
                        }
                    }
                }
            }

            item {
                Text(text = "Terbaru", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            items(terbarru, key = { it.id }) {
                ItemTerbaru(mterbaru = it, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
            }
        }

    }
}

