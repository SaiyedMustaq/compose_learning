package com.example.compose_learning


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_learning.screens.CartScreen
import com.example.compose_learning.screens.HomeScreen
import com.example.compose_learning.screens.ProfileScreen


@Composable
fun BottomNavigationBar() {
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItem().forEachIndexed{index,navItem->
                    NavigationBarItem(
                        label = {
                            Text(navItem.label)
                        },
                        selected = index == navigationSelectedItem,
                        onClick = {
                            println("Mustaq $index")
                            navigationSelectedItem = index
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    //saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }, icon = {
                        Icon(
                            navItem.icon,
                                contentDescription = navItem.label
                            )
                    })

                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.rout,
            modifier = Modifier.padding(paddingValues = paddingValues)) {
            composable(Screens.Home.rout) {
                HomeScreen(navController = navController)
            }
            composable(Screens.Notification.rout) {
                CartScreen(navController = navController)
            }
            composable(Screens.Profile.rout) {
                ProfileScreen(navController = navController)
            }
        }
    }
}

