package com.example.onehouse.Page.Component.Explore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.viewpager2.widget.ViewPager2
import com.example.onehouse.Page.Component.Explore.VideoAdapter
import com.example.onehouse.Page.Component.Explore.VidioItem
import com.example.onehouse.R
import com.example.onehouse.ui.theme.OneHouseTheme

@Composable
fun ItemExplore() {
    val context = LocalContext.current
    val videos = arrayListOf(
        VidioItem(R.raw.vid1, context, "a", "vsd"),
        VidioItem(R.raw.vid2, context, "b", "vsd"),
        VidioItem(R.raw.vid1, context, "c", "vsd"),
        VidioItem(R.raw.vid2, context, "d", "vsd"),
        VidioItem(R.raw.vid1, context, "e", "vsd")
    )

    OneHouseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(830.dp)
        ) {
            AndroidView(
                factory = { ctx ->
                    ViewPager2(ctx).apply {
                        adapter = VideoAdapter(videos)
                        orientation = ViewPager2.ORIENTATION_VERTICAL
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
