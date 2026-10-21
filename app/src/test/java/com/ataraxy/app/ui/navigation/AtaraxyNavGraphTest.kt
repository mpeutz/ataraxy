package com.ataraxy.app.ui.navigation

import android.net.Uri
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
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

    @Test
    fun reset_awayFromOnboarding_returnsToOnboardingAlone() {
        navController.navigate(Screen.Settings.route)

        navController.returnToOnboardingIfReset(onboardingComplete = false)

        assertEquals(Screen.Onboarding.route, navController.currentDestination?.route)
        assertNull(navController.previousBackStackEntry)
    }

    @Test
    fun reset_onOnboarding_staysPut() {
        navController.navigate(Screen.Onboarding.route)
        val onboarding = navController.currentBackStackEntry

        navController.returnToOnboardingIfReset(onboardingComplete = false)

        assertSame(onboarding, navController.currentBackStackEntry)
    }

    @Test
    fun completed_doesNotNavigate() {
        navController.navigate(Screen.Settings.route)

        navController.returnToOnboardingIfReset(onboardingComplete = true)

        assertEquals(Screen.Settings.route, navController.currentDestination?.route)
    }
    @Test
    fun cancelOnTwoLockedLayers_returnsPastBoth() {
        navController.navigate(Screen.Practices.route)
        navController.navigate(Screen.JournalHistory.route)
        navController.navigate("practice/edit/1")

        navController.leaveLockedRoute()

        assertEquals(Screen.Practices.route, navController.currentDestination?.route)
    }

    @Test
    fun cancelOnReflectionFlow_skipsWhatsYours() {
        navController.navigate(Screen.WhatsYours.route)
        navController.navigate(Screen.ReflectionFlow(1).route)

        navController.leaveLockedRoute()

        assertEquals(Screen.Home.route, navController.currentDestination?.route)
    }

    @Test
    fun cancelOnOneLockedLayer_returnsToPreviousScreen() {
        navController.navigate(Screen.Practices.route)
        navController.navigate(Screen.JournalHistory.route)

        navController.leaveLockedRoute()

        assertEquals(Screen.Practices.route, navController.currentDestination?.route)
    }

    @Test
    fun cancelWithNothingBehind_opensHomeAlone() {
        navController.navigate(Screen.JournalHistory.route) { popUpTo(navController.graph.id) { inclusive = true } }

        navController.leaveLockedRoute()

        assertEquals(Screen.Home.route, navController.currentDestination?.route)
        assertNull(navController.previousBackStackEntry)
    }

    @Test
    fun openEntryTwice_keepsOneEntryOnTop() {
        navController.openEntry(5)
        navController.openEntry(5)

        assertEquals(Screen.Entry.ROUTE, navController.currentDestination?.route)
        assertEquals(Screen.Home.route, navController.previousBackStackEntry?.destination?.route)
    }

    @Test
    fun cancelWithOnlyLockedScreensBehind_opensHomeAlone() {
        navController.navigate(Screen.JournalHistory.route) { popUpTo(navController.graph.id) { inclusive = true } }
        navController.navigate("practice/edit/1")

        navController.leaveLockedRoute()

        assertEquals(Screen.Home.route, navController.currentDestination?.route)
        assertNull(navController.previousBackStackEntry)
    }
}
