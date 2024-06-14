package com.example.onehouse.routing

sealed class screen(val route: String) {
    data object Home : screen("homescreen")
    data object Explore : screen("homeexplore")
    data object Favorite : screen("homefavorite")
    data object Chat : screen("homechat")
    data object Profile : screen("homeprofile")
    data object daftarApartment : screen("daftarApartment")
    data object daftarVilla : screen("daftarVilla")
    data object daftarTanah: screen("daftarTanah")
    data object daftarRumah:screen("daftarRumah")
    data object detailRumah : screen("detailRumah")
    data object detailApart : screen("detailApart")
    data object detailVilla : screen("detailVilla")
    data object detailTanah : screen("detailTanah")


}