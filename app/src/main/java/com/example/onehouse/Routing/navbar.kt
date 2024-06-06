package com.example.onehouse.Routing


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.onehouse.Page.Chat
import com.example.onehouse.Page.Explore
import com.example.onehouse.Page.Favorite
import com.example.onehouse.Page.Home
import com.example.onehouse.Page.Profile
import com.example.onehouse.R
import com.navbar_explore.Routing.navItem
import com.navbar_explore.Routing.screen

@Composable
fun Navbar(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    containerColor: Color = Color(0xFF6200EE),
) {
    Scaffold(
        bottomBar = {
            NavBottomBar(navController)
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(screen.Home.route) {
                Home(navHostController = navController)
            }

            composable(screen.Explore.route) {
                Explore()
            }

            composable(screen.Favorite.route) {
                Favorite()
            }
            composable(screen.Chat.route) {
                Chat()
            }
            composable(screen.Profile.route) {
                Profile()
            }
//            composable(
//                Screen.Detail.route + "/{filmId}",
//                arguments = listOf(navArgument("filmId") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                DetailHome(
//                    navController = navController,
//                    filmId = navBackStackEntry.arguments?.getInt("filmId")
//                )
//            }
        }
    }
}

@Composable
fun NavBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .border(1.5.dp, Color.Gray)
            .padding(1.dp)
    ) {
        NavigationBar(
            modifier = modifier,
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.contentColorFor(Color(0xff121212)),
            tonalElevation = NavigationBarDefaults.Elevation.plus(20.dp)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route


            val navItem = listOf(
                navItem(
                    title = stringResource(id = R.string.homescreen),
                    icon = Icons.Default.Home,
                    screen = screen.Home,
                ),
                navItem(
                    title = stringResource(id = R.string.homeexplore),
                    icon = Icons.Default.Search,
                    screen = screen.Explore,
                ),
                navItem(
                    title = stringResource(id = R.string.homefavorite),
                    icon = Icons.Default.Favorite,
                    screen = screen.Favorite,
                ),
                navItem(
                    title = stringResource(id = R.string.homechat),
                    icon = Icons.Default.Call,
                    screen = screen.Chat,
                ),
                navItem(
                    title = stringResource(id = R.string.homeprofile),
                    icon = Icons.Default.Person,
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
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = Color.Black,
                        )
                    },
                    label = { Text(text = item.title) }
                )
            }
        }
    }
}