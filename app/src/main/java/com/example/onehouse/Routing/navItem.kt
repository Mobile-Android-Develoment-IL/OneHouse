package com.navbar_explore.Routing

import android.icu.text.CaseMap.Title
import androidx.compose.ui.graphics.vector.ImageVector

data class navItem(
    val title: String,
    val icon: ImageVector,
    val screen: screen,
)
