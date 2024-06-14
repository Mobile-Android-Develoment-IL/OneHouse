package com.example.onehouse.page.component.favorit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onehouse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favoritee() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorite Houses") }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            FavoriteHousesScreen(houses = favoriteHouses)
        }
    }
}

@Composable
fun FavoriteHousesScreen(houses: List<Rumah>) {
    LazyColumn {
        items(houses) { house ->
            HouseItem(house = house)
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Composable
fun HouseItem(house: Rumah) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .clickable { /* Navigasi ke detail rumah */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = house.image),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(house.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(house.location, fontSize = 14.sp, color = Color.Gray)
            Text(house.price, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Green)
        }
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = null,
            tint = Color.Red
        )
    }
}
