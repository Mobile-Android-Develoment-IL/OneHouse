package com.example.onehouse.Page.Component.Home.kategori

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onehouse.R
import com.example.onehouse.ui.theme.OneHouseTheme

@Composable
fun ItemKategori(modifier: Modifier = Modifier,
                 mkategori : MKategori,
                 onItemClicked : (Int)-> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(mkategori.id)
        }
    ){
        Image(painter = painterResource(id = mkategori.iconn), contentDescription = mkategori.namekategori, modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = mkategori.namekategori, fontSize = 16.sp)
    }
    Spacer(modifier = Modifier.width(10.dp))
}

@Preview(showBackground = true)
@Composable
private fun KategoriItemPreview() {
    OneHouseTheme {
        ItemKategori(mkategori = MKategori(1, "Rumah",R.drawable.house),
            onItemClicked = { mkategoriId ->
                println("Kategori Id : $mkategoriId")
            }
        )
    }
}