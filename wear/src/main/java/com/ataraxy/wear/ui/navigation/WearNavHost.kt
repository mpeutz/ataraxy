package com.ataraxy.wear.ui.navigation

import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.ataraxy.wear.ui.quote.QuoteScreen

@Composable
fun WearNavHost() {
    val navController = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = WearDestinations.QUOTE
    ) {
        composable(WearDestinations.QUOTE) {
            QuoteScreen()
        }
    }
}
