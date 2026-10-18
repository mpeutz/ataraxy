package com.ataraxy.app.ui.components

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHeightIsAtLeast
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SharedComponentsTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun topBar_backButtonIsLabeledAndTitleIsAHeading() {
        var backClicked = false
        composeRule.setContent { AtaraxyTopBar(title = "JOURNAL", onBack = { backClicked = true }) }

        composeRule.onNodeWithContentDescription("Back").performClick()

        assertTrue(backClicked)
        composeRule.onNodeWithText("JOURNAL").assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
    }

    @Test
    fun segmentedToggle_segmentsAreTallEnoughRadioButtons() {
        composeRule.setContent {
            SegmentedToggle(options = listOf(1 to "ONE", 2 to "TWO"), selected = 1, onSelect = {})
        }

        val selectedSegment = composeRule.onNodeWithText("ONE")
        selectedSegment.assertIsSelected()
        selectedSegment.assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.RadioButton))
        composeRule.onNodeWithText("TWO").assertHeightIsAtLeast(48.dp)
    }
}
