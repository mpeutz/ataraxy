package com.ataraxy.app.ui.practices.whatsyours

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.test.junit4.v2.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LineListTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun removeButtons_areLabeledWithTheirLine() {
        var removed: Int? = null
        composeRule.setContent {
            Column {
                LineList(
                    question = "WHAT PART OF THIS IS YOURS?",
                    hint = "",
                    lines = listOf("Call my sister", "Finish the draft"),
                    draft = "",
                    onDraftChange = {},
                    onAdd = {},
                    onRemove = { removed = it }
                )
            }
        }

        composeRule.onNodeWithContentDescription("Remove “Call my sister”").assertExists()
        composeRule.onNodeWithContentDescription("Remove “Finish the draft”").performClick()

        assertEquals(1, removed)
    }
}
