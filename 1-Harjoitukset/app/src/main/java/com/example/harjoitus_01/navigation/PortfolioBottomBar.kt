package com.example.harjoitus_01.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavDestination.Companion.hasRoute

@Composable
fun PortfolioBottomBar(
    navController: NavHostController
) {
    val backStackEntry = navController
        .currentBackStackEntryAsState()
        .value

    val currentDestination = backStackEntry?.destination

    val profileSelected =
        currentDestination?.hasRoute<ProfileRoute>() == true

    val portfolioSelected =
        currentDestination?.hasRoute<PortfolioRoute>() == true

    NavigationBar {
        NavigationBarItem(
            selected = profileSelected,
            onClick = {
                navController.navigate(ProfileRoute) {
                    popUpTo(ProfileRoute) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profiili"
                )
            },
            label = {
                Text("Profiili")
            }
        )

        NavigationBarItem(
            selected = portfolioSelected,
            onClick = {
                navController.navigate(PortfolioRoute) {
                    popUpTo(ProfileRoute)
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Work,
                    contentDescription = "Portfolio"
                )
            },
            label = {
                Text("Portfolio")
            }
        )
    }
}