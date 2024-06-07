package com.example.onehouse.Page

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onehouse.Page.Component.Explore.ItemExplore

@Composable
fun Explore(
//    navController: NavController,
    modifier: Modifier = Modifier
) {
    ItemExplore()

}

@Preview
@Composable
private fun PrevExplore() {
    Explore()
}