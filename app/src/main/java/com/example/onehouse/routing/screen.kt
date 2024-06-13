package com.navbar_explore.Routing

sealed class screen(val route: String) {
    data object Home : screen("homescreen")
    data object Explore : screen("homeexplore")
    data object Favorite : screen("homefavorite")
    data object Chat : screen("homechat")
    data object Profile : screen("homeprofile")
    data object daftarRumah : screen("daftarRumah")
    data object daftarApartment : screen("daftarApartment")
    data object daftarVilla : screen("daftarVilla")
    data object daftarTanah: screen("daftarTanah")
    object detailRumah : screen("detailRumah")

}