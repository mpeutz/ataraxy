package com.ataraxy.app.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.ataraxy.app.ui.archive.ArchiveScreen
import com.ataraxy.app.ui.author.AuthorDetailScreen
import com.ataraxy.app.ui.insight.InsightScreen
import com.ataraxy.app.ui.home.HomeScreen
import com.ataraxy.app.ui.onboarding.OnboardingScreen
import com.ataraxy.app.ui.practice.PracticeScreen
import com.ataraxy.app.ui.practices.bookend.BookendRitualScreen
import com.ataraxy.app.ui.practices.dichotomy.DichotomyScreen
import com.ataraxy.app.ui.practices.hub.PracticesHubScreen
import com.ataraxy.app.ui.practices.journal.JournalHistoryScreen
import com.ataraxy.app.ui.practices.mementomori.MementoMoriScreen
import com.ataraxy.app.ui.practices.mementomori.MementoMoriInsightScreen
import com.ataraxy.app.ui.practices.sos.SosScreen
import com.ataraxy.app.ui.settings.AboutScreen
import com.ataraxy.app.ui.settings.SettingsScreen
import com.ataraxy.app.ui.virtue.VirtueDetailScreen

@Composable
fun AtaraxyNavHost() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route
    val navViewModel: AtaraxyNavViewModel = hiltViewModel()
    val onboardingComplete by navViewModel.onboardingComplete.collectAsState(initial = null)

    val showBottomBar = currentRoute != Screen.Onboarding.route &&
        currentRoute != null

    // Wait until we know onboarding status before showing anything
    if (onboardingComplete == null) {
        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background))
        return
    }

    val startDestination = if (onboardingComplete == true) Screen.Home.route else Screen.Onboarding.route

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            enterTransition = { fadeIn(tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
            popEnterTransition = { fadeIn(tween(300)) },
            popExitTransition = { fadeOut(tween(300)) }
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToPractice = { quoteId ->
                        navController.navigate(Screen.Practice.BASE + if (quoteId != null) "?quoteId=$quoteId" else "")
                    },
                    onNavigateToAuthor = { authorId -> navController.navigate("author/$authorId") }
                )
            }

            composable(
                route = Screen.Practice.ROUTE,
                arguments = listOf(
                    navArgument("quoteId") {
                        type = NavType.StringType
                        nullable = true
                        defaultValue = null
                    }
                ),
                deepLinks = listOf(
                    navDeepLink { uriPattern = "ataraxy://practice/{quoteId}" }
                )
            ) {
                PracticeScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
                )
            }

            // Also allow plain "practice" without quoteId
            composable(Screen.Practice.BASE) {
                PracticeScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
                )
            }

            composable(Screen.Archive.route) {
                ArchiveScreen(
                    onNavigateToPractice = { quoteId ->
                        navController.navigate("${Screen.Practice.BASE}?quoteId=$quoteId")
                    },
                    onNavigateToVirtueDetail = { virtueId ->
                        navController.navigate("virtue/$virtueId")
                    },
                    onNavigateToInsight = { quoteId ->
                        navController.navigate("insight/$quoteId")
                    },
                    onNavigateToAuthor = { authorId -> navController.navigate("author/$authorId") }
                )
            }

            composable(
                route = Screen.Insight.ROUTE,
                arguments = listOf(navArgument("quoteId") { type = NavType.StringType })
            ) { backStackEntry ->
                InsightScreen(
                    quoteId = backStackEntry.arguments?.getString("quoteId") ?: "",
                    onBack = { navController.popBackStack() },
                    onNavigateToAuthor = { authorId -> navController.navigate("author/$authorId") }
                )
            }

            composable(
                route = Screen.VirtueDetail.ROUTE,
                arguments = listOf(navArgument("virtueId") { type = NavType.StringType })
            ) { backStackEntry ->
                VirtueDetailScreen(
                    virtueId = backStackEntry.arguments?.getString("virtueId") ?: "",
                    onNavigateToPractice = { quoteId ->
                        navController.navigate("${Screen.Practice.BASE}?quoteId=$quoteId")
                    },
                    onBack = { navController.popBackStack() }
                )
            }

            composable(Screen.Settings.route) {
                SettingsScreen(
                    onNavigateToAbout = { navController.navigate(Screen.About.route) }
                )
            }

            composable(Screen.About.route) {
                AboutScreen(onBack = { navController.popBackStack() })
            }

            composable(Screen.Onboarding.route) {
                OnboardingScreen(
                    onComplete = {
                        navViewModel.completeOnboarding()
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Onboarding.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Practices.route) {
                PracticesHubScreen(
                    onNavigateToBookend = { navController.navigate(Screen.BookendRitual.route) },
                    onNavigateToDichotomy = { navController.navigate(Screen.DichotomyOfControl.route) },
                    onNavigateToSos = { navController.navigate(Screen.SosQuotes.route) },
                    onNavigateToMementoMori = { navController.navigate(Screen.MementoMori.route) },
                    onNavigateToJournal = { navController.navigate(Screen.JournalHistory.route) }
                )
            }

            composable(Screen.JournalHistory.route) {
                JournalHistoryScreen(
                    onBack = { navController.popBackStack() },
                    onEditEntry = { entry ->
                        navController.navigate("practice/edit/${entry.id}")
                    }
                )
            }

            composable(
                route = Screen.PracticeEdit.ROUTE,
                arguments = listOf(navArgument("entryId") { type = NavType.LongType })
            ) {
                PracticeScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
                )
            }

            composable(
                Screen.BookendRitual.route,
                deepLinks = listOf(navDeepLink { uriPattern = "ataraxy://bookend" })
            ) {
                BookendRitualScreen(onBack = { navController.popBackStack() })
            }

            composable(Screen.DichotomyOfControl.route) {
                DichotomyScreen(onBack = { navController.popBackStack() })
            }

            composable(Screen.SosQuotes.route) {
                SosScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
                )
            }

            composable(Screen.MementoMori.route) {
                MementoMoriScreen(
                    onBack = { navController.popBackStack() },
                    onNavigateToInsight = { navController.navigate(Screen.MementoMoriInsight.route) }
                )
            }

            composable(Screen.MementoMoriInsight.route) {
                MementoMoriInsightScreen(onBack = { navController.popBackStack() })
            }

            composable(
                route = Screen.AuthorDetail.ROUTE,
                arguments = listOf(navArgument("authorId") { type = NavType.StringType })
            ) { backStackEntry ->
                val authorId = backStackEntry.arguments?.getString("authorId") ?: return@composable
                AuthorDetailScreen(
                    authorId = authorId,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
