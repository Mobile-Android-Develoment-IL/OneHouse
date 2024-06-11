package com.example.onehouse.page.component.home.kategori

import com.example.onehouse.R
import com.navbar_explore.Routing.screen

object dataKategori {
 val Kategoridt = listOf(
     MKategori(
         id = 1,
         namekategori = "Rumah",
         iconn = R.drawable.house,
         route = screen.daftarRumah.route
     ),
     MKategori(
         id = 2,
         namekategori = "Apartment",
         iconn = R.drawable.apartment,
         route = screen.daftarRumah.route
     ),
     MKategori(
         id = 3,
         namekategori = "Villa",
         iconn = R.drawable.villa,
         route = screen.daftarRumah.route
     ),
     MKategori(
         id = 4,
         namekategori = "Tanah",
         iconn = R.drawable.tanah,
         route = screen.daftarRumah.route
     )
 )
}