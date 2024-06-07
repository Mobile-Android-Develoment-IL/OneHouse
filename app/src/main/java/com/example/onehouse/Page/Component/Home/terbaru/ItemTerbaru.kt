package com.example.onehouse.Page.Component.Home.terbaru

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.Page.Component.Home.recomendasi.ItemRekomen
import com.example.onehouse.Page.Component.Home.recomendasi.MRekomendasi
import com.example.onehouse.R
import com.example.onehouse.ui.theme.OneHouseTheme

@Composable
fun ItemTerbaru(modifier: Modifier = Modifier,
                mterbaru : MTerbaru,
                ) {
    Card (
        modifier = Modifier

            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        ){
            Image(
                painter = painterResource(id = mterbaru.photoRmh),
                contentDescription = "rmhterbaru",
                modifier = Modifier
                    .width(120.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column (modifier = Modifier,){
                Text(text = mterbaru.judulrumah, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Harga       " + mterbaru.harga)
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Image(painter = painterResource(id = R.drawable.map), contentDescription = "map", modifier = Modifier.size(20.dp) )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Jl. Mangga2, Block A")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TerbaruItemPreview() {
    OneHouseTheme {
        ItemTerbaru(mterbaru = MTerbaru(1,R.drawable.rumahtr1,"Rumah Type 13 Minimalis","Rp. 600.000.000",R.drawable.map),

        )
    }
}