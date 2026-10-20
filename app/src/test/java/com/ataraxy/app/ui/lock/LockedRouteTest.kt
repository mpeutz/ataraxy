package com.ataraxy.app.ui.lock

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.ataraxy.app.ui.navigation.LOCKED_ROUTES
import com.ataraxy.app.ui.navigation.Screen
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LockedRouteTest {

    @get:Rule
    val composeRule = createComposeRule()

    private var requests = 0
    private var unlockedCalls = 0
    private var cancelCalls = 0

    private fun setRoute(startUnlocked: Boolean, result: Boolean) {
        composeRule.setContent {
            var unlocked by remember { mutableStateOf(startUnlocked) }
            LockedRoute(
                isUnlocked = unlocked,
                onUnlockRequest = {
                    requests++
                    result
                },
                onUnlocked = {
                    unlockedCalls++
                    unlocked = true
                },
                onCancel = { cancelCalls++ }
            ) {
                Box(Modifier.testTag(CONTENT))
            }
        }
    }

    @Test
    fun locked_neverShowsContent_andRequestsUnlockOnce() {
        setRoute(startUnlocked = false, result = false)
        composeRule.waitForIdle()

        composeRule.onNodeWithTag(CONTENT).assertDoesNotExist()
        assertEquals(1, requests)
    }

    @Test
    fun unlockSucceeds_showsContentAndCallsOnUnlocked() {
        setRoute(startUnlocked = false, result = true)
        composeRule.waitForIdle()

        composeRule.onNodeWithTag(CONTENT).assertExists()
        assertEquals(1, unlockedCalls)
        assertEquals(0, cancelCalls)
    }

    @Test
    fun unlockCancelled_callsOnCancel_contentNeverShown() {
        setRoute(startUnlocked = false, result = false)
        composeRule.waitForIdle()

        composeRule.onNodeWithTag(CONTENT).assertDoesNotExist()
        assertEquals(1, cancelCalls)
        assertEquals(0, unlockedCalls)
    }

    @Test
    fun alreadyUnlocked_showsContentWithoutPrompt() {
        setRoute(startUnlocked = true, result = true)
        composeRule.waitForIdle()

        composeRule.onNodeWithTag(CONTENT).assertExists()
        assertEquals(0, requests)
    }

    @Test
    fun lockedRoutes_areExactlyTheFiveJournalScreens() {
        assertEquals(
            setOf(
                Screen.JournalHistory.route,
                Screen.PracticeEdit.ROUTE,
                Screen.WhatsYours.route,
                Screen.ReflectionFlow.ROUTE,
                Screen.ReflectionDetail.ROUTE
            ),
            LOCKED_ROUTES
        )
    }

    private companion object {
        const val CONTENT = "content"
    }
}
