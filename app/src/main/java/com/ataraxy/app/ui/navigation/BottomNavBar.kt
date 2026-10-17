package com.ataraxy.app.ui.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.SelfImprovement
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val contentDescription: String
)

private val practicesRoutes = setOf(
    Screen.Practices.route,
    Screen.BookendRitual.route,
    Screen.DichotomyOfControl.route,
    Screen.SosQuotes.route,
    Screen.MementoMori.route,
    Screen.JournalHistory.route
)

private val navItems = listOf(
    BottomNavItem(Screen.Home.route, Icons.Outlined.Home, "Home"),
    BottomNavItem(Screen.Practice.BASE, Icons.Outlined.BookmarkBorder, "Practice"),
    BottomNavItem(Screen.Practices.route, Icons.Outlined.SelfImprovement, "Practices"),
    BottomNavItem(Screen.Archive.route, Icons.Outlined.Archive, "Archive"),
    BottomNavItem(Screen.Settings.route, Icons.Outlined.Settings, "Settings"),
)

@Composable
fun BottomNavBar(navController: NavController) {
    val currentBackStack = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack.value?.destination?.route

    NavigationBar(
        modifier = Modifier.height(64.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp
    ) {
        navItems.forEach { item ->
            val selected = currentRoute == item.route ||
                (item.route == Screen.Practice.BASE && currentRoute?.startsWith("${Screen.Practice.BASE}?") == true) ||
                (item.route == Screen.Practices.route && currentRoute in practicesRoutes)

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription,
                        modifier = Modifier.size(26.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
