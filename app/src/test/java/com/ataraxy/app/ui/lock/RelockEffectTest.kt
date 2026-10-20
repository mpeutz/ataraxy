package com.ataraxy.app.ui.lock

import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RelockEffectTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    private var isUnlocked by mutableStateOf(true)
    private var relocks by mutableIntStateOf(0)
    private var dismissals = 0

    private fun setEffect() {
        composeRule.setContent { RelockEffect(isUnlocked, relocks) { dismissals++ } }
        composeRule.waitForIdle()
    }

    @Test
    fun unlocked_leavesConfirmationsAlone() {
        setEffect()

        assertEquals(0, dismissals)
    }

    @Test
    fun locking_dismissesOnce() {
        setEffect()

        isUnlocked = false
        relocks = 1
        composeRule.waitForIdle()

        assertEquals(1, dismissals)
    }

    @Test
    fun relockWhileAlreadyLocked_dismissesAgain() {
        isUnlocked = false
        setEffect()

        relocks = 1
        composeRule.waitForIdle()

        assertEquals(2, dismissals)
    }

    @Test
    fun unlocking_doesNotDismiss() {
        isUnlocked = false
        setEffect()

        isUnlocked = true
        composeRule.waitForIdle()

        assertEquals(1, dismissals)
    }
}
