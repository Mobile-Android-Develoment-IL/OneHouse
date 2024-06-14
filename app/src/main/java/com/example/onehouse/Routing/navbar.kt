package com.example.onehouse.routing

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.onehouse.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navbar(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavBottomBar(navController = navController) }
    ) { innerPadding ->
        BottomGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
fun NavBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.contentColorFor(Color(0xff121212)),
        windowInsets = WindowInsets(bottom = 100)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navItem = listOf(
            navItem(
                title = stringResource(id = R.string.homescreen),
                icon = R.drawable.ic_home,
                screen = screen.Home,
            ),
            navItem(
                title = stringResource(id = R.string.homeexplore),
                icon = R.drawable.ic_explore,
                screen = screen.Explore,
            ),
            navItem(
                title = stringResource(id = R.string.homefavorite),
                icon = R.drawable.ic_fav,
                screen = screen.Favorite,
            ),
            navItem(
                title = stringResource(id = R.string.homechat),
                icon = R.drawable.ic_chat,
                screen = screen.Chat,
            ),
            navItem(
                title = stringResource(id = R.string.homeprofile),
                icon = R.drawable.ic_prof,
                screen = screen.Profile,
            ),
        )
        navItem.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = Color.Black,
                        modifier = Modifier.size(size = 25.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title, style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    )
                }
            )
        }
    }
}
