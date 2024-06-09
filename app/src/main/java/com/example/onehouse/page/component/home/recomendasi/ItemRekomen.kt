package com.example.onehouse.page.component.home.recomendasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onehouse.R
import com.example.onehouse.ui.theme.OneHouseTheme

@Composable
fun ItemRekomen(modifier: Modifier = Modifier,
                mrekomendasi : MRekomendasi,
                onItemClicked : (Int)-> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(mrekomendasi.id)
        }    ){
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(180.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Image(painter = painterResource(id = mrekomendasi.photoRec) , contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun RekomendasiItemPreview() {
    OneHouseTheme {
        ItemRekomen(mrekomendasi = MRekomendasi(1,R.drawable.recom1),
            onItemClicked = { mrekomendasiId ->
                println("Recomen Id : $mrekomendasiId")
            }
        )
    }
}