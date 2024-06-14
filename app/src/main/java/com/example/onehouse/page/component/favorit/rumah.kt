package com.example.onehouse.page.component.favorit

import com.example.onehouse.R

data class Rumah(
    val id: Int,
    val image: Int,
    val title: String,
    val price: String,
    val location: String,
    val isFavorite: Boolean
)

val favoriteHouses = listOf(
    Rumah(1, R.drawable.apart1, "Modern House", "$500,000", "New York, NY", true),
    Rumah(2, R.drawable.apart3, "Family House", "$350,000", "San Francisco, CA", true)
)

