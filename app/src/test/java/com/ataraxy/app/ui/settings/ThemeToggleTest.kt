package com.ataraxy.app.ui.settings

import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.ataraxy.app.domain.model.AppTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ThemeToggleTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun tappingSystem_selectsSystemTheme() {
        var selected: AppTheme? = null
        composeRule.setContent {
            ThemeToggle(current = AppTheme.DARK, onSelect = { selected = it })
        }

        composeRule.onNodeWithText("SYSTEM").performClick()

        assertEquals(AppTheme.SYSTEM, selected)
    }
}
