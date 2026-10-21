package com.ataraxy.app.ui.lock

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.ataraxy.app.ui.navigation.LOCKED_ROUTES
import com.ataraxy.app.ui.navigation.Screen
import android.view.WindowManager
import kotlinx.coroutines.CompletableDeferred
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LockedRouteTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    private var requests = 0
    private var unlockedCalls = 0
    private var cancelCalls = 0

    private fun setRoute(startUnlocked: Boolean, result: Boolean) {
        composeRule.setContent {
            var unlocked by remember { mutableStateOf(startUnlocked) }
            LockedRoute(
                isUnlocked = unlocked,
                secure = true,
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
    fun pendingPrompt_hidesContentUntilItCompletesWithTrue() {
        val prompt = CompletableDeferred<Boolean>()
        composeRule.setContent {
            var unlocked by remember { mutableStateOf(false) }
            LockedRoute(
                isUnlocked = unlocked,
                secure = true,
                onUnlockRequest = { prompt.await() },
                onUnlocked = { unlocked = true },
                onCancel = { cancelCalls++ }
            ) {
                Box(Modifier.testTag(CONTENT))
            }
        }
        composeRule.waitForIdle()
        composeRule.onNodeWithTag(CONTENT).assertDoesNotExist()

        prompt.complete(true)
        composeRule.waitForIdle()

        composeRule.onNodeWithTag(CONTENT).assertExists()
        assertEquals(0, cancelCalls)
    }

    @Test
    fun secureFlag_staysWhileAnotherLockedRouteIsComposed() {
        var first by mutableStateOf(true)
        var second by mutableStateOf(true)
        composeRule.setContent {
            if (first) LockedRoute(true, true, { true }, {}, {}) { Box(Modifier.testTag("a")) }
            if (second) LockedRoute(true, true, { true }, {}, {}) { Box(Modifier.testTag("b")) }
        }
        composeRule.waitForIdle()
        assertTrue(isSecure())

        first = false
        composeRule.waitForIdle()
        assertTrue(isSecure())

        second = false
        composeRule.waitForIdle()
        assertFalse(isSecure())
    }

    @Test
    fun lockOff_leavesScreenshotsAndRecentsAlone() {
        composeRule.setContent {
            LockedRoute(true, secure = false, { true }, {}, {}) { Box(Modifier.testTag(CONTENT)) }
        }
        composeRule.waitForIdle()

        composeRule.onNodeWithTag(CONTENT).assertExists()
        assertFalse(isSecure())
    }

    @Test
    fun lockOn_setsSecureFlag_untilTurnedOff() {
        var secure by mutableStateOf(true)
        composeRule.setContent {
            LockedRoute(true, secure, { true }, {}, {}) { Box(Modifier.testTag(CONTENT)) }
        }
        composeRule.waitForIdle()
        assertTrue(isSecure())

        secure = false
        composeRule.waitForIdle()
        assertFalse(isSecure())
    }

    private fun isSecure(): Boolean {
        val flags = composeRule.activity.window.attributes.flags
        return flags and WindowManager.LayoutParams.FLAG_SECURE != 0
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
