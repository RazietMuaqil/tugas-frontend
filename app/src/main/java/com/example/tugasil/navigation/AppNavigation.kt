package com.example.tugasil.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.U
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tugasil.detail.detailavg
import com.example.tugasil.detail.detailspider
import com.example.tugasil.screen.screen1
import com.example.tugasil.screen.screen2


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listOfNavItems.forEach{ navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any{ it.route == navItem.route} == true,
                        onClick = {
                            navController.navigate(navItem.route){
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = null)
                        },
                        label = {
                            Text(text = navItem.label)

                        }

                    )
                }

            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Screens.HomeScreen.name) {
                screen1(navController = navController)
            }
            composable(route = Screens.HomeScreen2.name) {
                screen2(navController = navController)
            }
            composable(route = Screens.ProfileScreen.name) {

            }
            composable(route = Screens.detailavg.name + "/{AvengersId}", arguments = listOf(
                navArgument("AvengersId"){
                    type = NavType.IntType
                }) ){
                    navBackStackEntry ->
                detailavg(navController = navController, AvengersId = navBackStackEntry.arguments?.getInt("AvengersId"))
            }
            composable(route = Screens.detailspider.name + "/{SpiderId}", arguments = listOf(
                navArgument("SpiderId"){
                    type = NavType.IntType
                }) ){
                    navBackStackEntry ->
                detailspider(navController = navController, SpidermanId = navBackStackEntry.arguments?.getInt("SpiderId"))
            }
        }
    }
}