package com.example.onehouse.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.onehouse.page.component.profile.ItemProfile
import com.example.onehouse.page.component.profile.Settings
import com.example.onehouse.page.component.profile.data.data

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(data.profile) { profile ->
            ItemProfile(imageIc = profile, navController = navController)
        }
        item {
            Settings()
        }
    }

}