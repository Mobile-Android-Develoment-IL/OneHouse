package com.example.onehouse.Page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.onehouse.Page.Component.Home.kategori.ItemKategori
import com.example.onehouse.Page.Component.Home.kategori.MKategori
import com.example.onehouse.Page.Component.Home.kategori.dataKategori
import com.example.onehouse.Page.Component.Home.recomendasi.ItemRekomen
import com.example.onehouse.Page.Component.Home.recomendasi.MRekomendasi
import com.example.onehouse.Page.Component.Home.recomendasi.dataRekomendasi
import com.example.onehouse.Page.Component.Home.terbaru.ItemTerbaru
import com.example.onehouse.Page.Component.Home.terbaru.MTerbaru
import com.example.onehouse.Page.Component.Home.terbaru.dataTerbaru
import com.example.onehouse.R


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

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
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
                    .weight(1f)
                    .height(50.dp)
            ) {}
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 45.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = null
                )
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Kategori", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            item {
                LazyRow(
                    contentPadding = PaddingValues(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = modifier
                ) {
                    items(kategoris, key = { it.id }) {
                        ItemKategori(mkategori = it) { mkategoriId ->
                            // navController.navigate(Screen.Detail.route + "/$mkategoriId")
                        }
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
                            // navController.navigate(Screen.Detail.route + "/$mrekomendasiId")
                        }
                    }
                }
            }

            item {
                Text(text = "Terbaru", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            items(terbarru, key = { it.id }) {
                ItemTerbaru(mterbaru = it, modifier = Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

