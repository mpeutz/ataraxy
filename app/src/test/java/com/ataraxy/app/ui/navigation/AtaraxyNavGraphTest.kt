package com.ataraxy.app.ui.navigation

import android.net.Uri
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AtaraxyNavGraphTest {

    private val navController = TestNavHostController(ApplicationProvider.getApplicationContext()).apply {
        navigatorProvider.addNavigator(ComposeNavigator())
        graph = createGraph(startDestination = Screen.Home.route) { ataraxyGraph(this@apply, onOnboardingComplete = {}) }
    }

    @Test
    fun practiceLinkWithoutQuote_opensFreeformPractice() {
        navController.navigate(Uri.parse("ataraxy://practice"))

        assertEquals(Screen.Practice.BASE, navController.currentDestination?.route)
    }

    @Test
    fun practiceLinkWithQuote_passesQuoteId() {
        navController.navigate(Uri.parse("ataraxy://practice/q42"))

        assertEquals("q42", navController.currentBackStackEntry?.arguments?.getString("quoteId"))
    }

    @Test
    fun homeLink_opensHome() {
        navController.navigate(Screen.Settings.route)

        navController.navigate(Uri.parse("ataraxy://home"))

        assertEquals(Screen.Home.route, navController.currentDestination?.route)
    }

    @Test
    fun isShowing_matchesOnlyTheSameScreenWithTheSameArguments() {
        navController.navigate(Uri.parse("ataraxy://practice/q1"))
        val entry = navController.currentBackStackEntry

        assertTrue(isShowing(entry, Uri.parse("ataraxy://practice/q1")))
        assertFalse(isShowing(entry, Uri.parse("ataraxy://practice/q2")))
        assertFalse(isShowing(entry, Uri.parse("ataraxy://bookend")))
    }

    @Test
    fun isShowing_matchesArgumentFreeScreen() {
        navController.navigate(Uri.parse("ataraxy://bookend"))

        assertTrue(isShowing(navController.currentBackStackEntry, Uri.parse("ataraxy://bookend")))
    }

    @Test
    fun bookendLink_opensBookend() {
        navController.navigate(Uri.parse("ataraxy://bookend"))

        assertEquals(Screen.BookendRitual.route, navController.currentDestination?.route)
    }
}
