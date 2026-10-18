package com.ataraxy.app.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performFirstLinkClick
import androidx.compose.ui.text.TextStyle
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AnnotatedQuoteTextTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun tappingGlossaryTerm_showsItsDefinition() {
        composeRule.setContent {
            AnnotatedQuoteText(text = "Follow the logos in all things.", style = TextStyle(), color = Color.Black)
        }

        composeRule.onNodeWithText("Follow the logos in all things.").performFirstLinkClick()

        composeRule.onNodeWithText("Logos").assertExists()
    }
}
