package com.ataraxy.app.ui.navigation

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.Consumer
import androidx.fragment.app.FragmentActivity
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.ataraxy.app.R
import com.ataraxy.app.ui.archive.ArchiveScreen
import com.ataraxy.app.ui.author.AuthorDetailScreen
import com.ataraxy.app.ui.home.HomeScreen
import com.ataraxy.app.ui.insight.InsightScreen
import com.ataraxy.app.ui.lock.LockViewModel
import com.ataraxy.app.ui.lock.LockedRoute
import com.ataraxy.app.ui.onboarding.OnboardingScreen
import com.ataraxy.app.ui.practice.PracticeScreen
import com.ataraxy.app.ui.practices.bookend.BookendRitualScreen
import com.ataraxy.app.ui.practices.hub.PracticesHubScreen
import com.ataraxy.app.ui.practices.journal.JournalHistoryScreen
import com.ataraxy.app.ui.practices.mementomori.MementoMoriInsightScreen
import com.ataraxy.app.ui.practices.mementomori.MementoMoriScreen
import com.ataraxy.app.ui.practices.sos.SosScreen
import com.ataraxy.app.ui.practices.whatsyours.ReflectionDetailScreen
import com.ataraxy.app.ui.practices.whatsyours.ReflectionFlowScreen
import com.ataraxy.app.ui.practices.whatsyours.WhatsYoursScreen
import com.ataraxy.app.ui.settings.AboutScreen
import com.ataraxy.app.ui.settings.SettingsScreen
import com.ataraxy.app.ui.virtue.VirtueDetailScreen

private val MaxContentWidth = 720.dp

/** Screens that show past writing; each asks for the unlock while App Lock is on. */
internal val LOCKED_ROUTES = setOf(
    Screen.JournalHistory.route,
    Screen.PracticeEdit.ROUTE,
    Screen.WhatsYours.route,
    Screen.ReflectionFlow.ROUTE,
    Screen.ReflectionDetail.ROUTE
)

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

    // Fixed at the first known value: a restore during onboarding flips the flag but must not swap the start.
    val startDestination = rememberSaveable {
        if (onboardingComplete == true) Screen.Home.route else Screen.Onboarding.route
    }

    NewIntentDeepLinks(navController, enabled = onboardingComplete == true)

    LaunchedEffect(onboardingComplete) {
        navController.returnToOnboardingIfReset(onboardingComplete)
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
        // On tablets and in landscape, keep screens at a readable width instead of stretching.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            NavHost(
                navController = navController,
                startDestination = startDestination,
                modifier = Modifier
                    .widthIn(max = MaxContentWidth)
                    .fillMaxSize(),
                enterTransition = { fadeIn(tween(300)) },
                exitTransition = { fadeOut(tween(300)) },
                popEnterTransition = { fadeIn(tween(300)) },
                popExitTransition = { fadeOut(tween(300)) }
            ) {
                ataraxyGraph(navController, onOnboardingComplete = navViewModel::completeOnboarding)
            }
        }
    }
}

/**
 * Opens deep links that arrive while the app is running (e.g. a notification tap) on top of the
 * current screens, so in-progress work stays on the back stack. Ignored until onboarding is done.
 */
@Composable
private fun NewIntentDeepLinks(navController: NavHostController, enabled: Boolean) {
    val activity = LocalActivity.current as? ComponentActivity ?: return
    val currentEnabled by rememberUpdatedState(enabled)
    DisposableEffect(activity, navController) {
        val listener = Consumer<Intent> { intent ->
            val uri = intent.data ?: return@Consumer
            if (!currentEnabled || !navController.graph.hasDeepLink(uri)) return@Consumer
            if (!isShowing(navController.currentBackStackEntry, uri)) navController.navigate(uri)
        }
        activity.addOnNewIntentListener(listener)
        onDispose { activity.removeOnNewIntentListener(listener) }
    }
}

/**
 * Deactivate clears every preference, so the app starts over at onboarding with nothing to go back to.
 * Finishing onboarding is left alone: onboarding navigates on by itself.
 */
internal fun NavHostController.returnToOnboardingIfReset(onboardingComplete: Boolean?) {
    if (onboardingComplete != false) return
    val route = currentDestination?.route ?: return
    if (route == Screen.Onboarding.route) return
    navigate(Screen.Onboarding.route) {
        popUpTo(graph.id) { inclusive = true }
    }
}

/**
 * Whether [entry] already displays [uri], so opening the link again would only duplicate it.
 * A link to the same screen with different arguments (another quote) is not a match.
 */
internal fun isShowing(entry: NavBackStackEntry?, uri: Uri): Boolean {
    if (entry == null || !entry.destination.hasDeepLink(uri)) return false
    val args = entry.arguments ?: return uri.pathSegments.isEmpty()
    val argValues = args.keySet().mapNotNull { args.getString(it) }.toSet()
    return uri.pathSegments.all { it in argValues }
}

@Composable
private fun LockGate(navController: NavHostController, content: @Composable () -> Unit) {
    val lock: LockViewModel = hiltViewModel()
    val activity = LocalActivity.current as? FragmentActivity
    val title = stringResource(R.string.lock_prompt_title)
    val isUnlocked by lock.appLock.isUnlocked.collectAsState()
    val enabled by lock.appLock.enabled.collectAsState()
    LockedRoute(
        isUnlocked = isUnlocked,
        secure = enabled,
        onUnlockRequest = { activity != null && lock.authenticator.authenticate(activity, title) },
        onUnlocked = lock.appLock::markUnlocked,
        onCancel = { navController.leaveLockedRoute() },
        content = content
    )
}

/** A destination that asks for the unlock first when its route is in [LOCKED_ROUTES]. */
private fun NavGraphBuilder.gatedComposable(
    navController: NavHostController,
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(route = route, arguments = arguments, deepLinks = deepLinks) { entry ->
        if (route in LOCKED_ROUTES) LockGate(navController) { content(entry) } else content(entry)
    }
}

private fun NavHostController.leaveLockedRoute() {
    if (previousBackStackEntry != null) {
        popBackStack()
        return
    }
    navigate(Screen.Home.route) { popUpTo(0) }
}

/** Every destination in the app. Kept separate from [AtaraxyNavHost] so the graph can be tested. */
internal fun NavGraphBuilder.ataraxyGraph(
    navController: NavHostController,
    onOnboardingComplete: () -> Unit
) {
    gatedComposable(navController, 
        route = Screen.Home.route,
        deepLinks = listOf(navDeepLink { uriPattern = "ataraxy://home" })
    ) {
        HomeScreen(
            onNavigateToPractice = { quoteId ->
                navController.navigate(Screen.Practice.BASE + if (quoteId != null) "?quoteId=$quoteId" else "")
            },
            onNavigateToAuthor = { authorId -> navController.navigate("author/$authorId") }
        )
    }

    gatedComposable(navController, 
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
    gatedComposable(navController, 
        route = Screen.Practice.BASE,
        deepLinks = listOf(navDeepLink { uriPattern = "ataraxy://practice" })
    ) {
        PracticeScreen(
            onBack = { navController.popBackStack() },
            onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
        )
    }

    gatedComposable(navController, Screen.Archive.route) {
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

    gatedComposable(navController, 
        route = Screen.Insight.ROUTE,
        arguments = listOf(navArgument("quoteId") { type = NavType.StringType })
    ) { backStackEntry ->
        InsightScreen(
            quoteId = backStackEntry.arguments?.getString("quoteId") ?: "",
            onBack = { navController.popBackStack() },
            onNavigateToAuthor = { authorId -> navController.navigate("author/$authorId") }
        )
    }

    gatedComposable(navController, 
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

    gatedComposable(navController, Screen.Settings.route) {
        SettingsScreen(
            onNavigateToAbout = { navController.navigate(Screen.About.route) }
        )
    }

    gatedComposable(navController, Screen.About.route) {
        AboutScreen(onBack = { navController.popBackStack() })
    }

    gatedComposable(navController, Screen.Onboarding.route) {
        OnboardingScreen(
            onComplete = {
                onOnboardingComplete()
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Onboarding.route) { inclusive = true }
                }
            }
        )
    }

    gatedComposable(navController, Screen.Practices.route) {
        PracticesHubScreen(
            onNavigateToBookend = { navController.navigate(Screen.BookendRitual.route) },
            onNavigateToWhatsYours = { navController.navigate(Screen.WhatsYours.route) },
            onNavigateToSos = { navController.navigate(Screen.SosQuotes.route) },
            onNavigateToMementoMori = { navController.navigate(Screen.MementoMori.route) },
            onNavigateToJournal = { navController.navigate(Screen.JournalHistory.route) }
        )
    }

    gatedComposable(navController, Screen.JournalHistory.route) {
        JournalHistoryScreen(
            onBack = { navController.popBackStack() },
            onEditEntry = { entry ->
                navController.navigate("practice/edit/${entry.id}")
            }
        )
    }

    gatedComposable(navController, 
        route = Screen.PracticeEdit.ROUTE,
        arguments = listOf(navArgument("entryId") { type = NavType.LongType })
    ) {
        PracticeScreen(
            onBack = { navController.popBackStack() },
            onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
        )
    }

    gatedComposable(navController, 
        Screen.BookendRitual.route,
        deepLinks = listOf(navDeepLink { uriPattern = "ataraxy://bookend" })
    ) {
        BookendRitualScreen(onBack = { navController.popBackStack() })
    }

    gatedComposable(navController, Screen.WhatsYours.route) {
        WhatsYoursScreen(
            onBack = { navController.popBackStack() },
            onBegin = { id -> navController.navigate(Screen.ReflectionFlow(id).route) },
            onOpenReflection = { reflection ->
                val target = if (reflection.completedAt == null) Screen.ReflectionFlow(reflection.id)
                else Screen.ReflectionDetail(reflection.id)
                navController.navigate(target.route)
            }
        )
    }

    gatedComposable(navController, 
        route = Screen.ReflectionFlow.ROUTE,
        arguments = listOf(navArgument("reflectionId") { type = NavType.LongType })
    ) {
        ReflectionFlowScreen(
            onClose = { navController.popBackStack() },
            onFinished = { id ->
                navController.navigate(Screen.ReflectionDetail(id).route) {
                    popUpTo(Screen.ReflectionFlow.ROUTE) { inclusive = true }
                }
            }
        )
    }

    gatedComposable(navController, 
        route = Screen.ReflectionDetail.ROUTE,
        arguments = listOf(navArgument("reflectionId") { type = NavType.LongType })
    ) {
        ReflectionDetailScreen(onBack = { navController.popBackStack() })
    }

    gatedComposable(navController, Screen.SosQuotes.route) {
        SosScreen(
            onBack = { navController.popBackStack() },
            onNavigateToInsight = { quoteId -> navController.navigate("insight/$quoteId") }
        )
    }

    gatedComposable(navController, Screen.MementoMori.route) {
        MementoMoriScreen(
            onBack = { navController.popBackStack() },
            onNavigateToInsight = { navController.navigate(Screen.MementoMoriInsight.route) }
        )
    }

    gatedComposable(navController, Screen.MementoMoriInsight.route) {
        MementoMoriInsightScreen(onBack = { navController.popBackStack() })
    }

    gatedComposable(navController, 
        route = Screen.AuthorDetail.ROUTE,
        arguments = listOf(navArgument("authorId") { type = NavType.StringType })
    ) { backStackEntry ->
        val authorId = backStackEntry.arguments?.getString("authorId") ?: return@gatedComposable
        AuthorDetailScreen(
            authorId = authorId,
            onBack = { navController.popBackStack() }
        )
    }
}
