package com.ataraxy.app.ui.components.orrery

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OrreryGeneratorTest {

    @Test
    fun sameSeed_alwaysProducesTheSameDrawing() {
        assertEquals(generateOrrery("home"), generateOrrery("home"))
    }

    @Test
    fun differentSeeds_produceDifferentDrawings() {
        assertNotEquals(generateOrrery("home"), generateOrrery("practice"))
    }

    @Test
    fun drawing_containsEveryKindOfElement() {
        val drawing = generateOrrery("insight")

        assertTrue(drawing.rings.size >= 6)
        assertTrue(drawing.arcs.size == 3)
        assertTrue(drawing.lines.size >= 2)
        assertTrue(drawing.satellites.size in 4..5)
        assertTrue(drawing.dots.isNotEmpty())
    }

    @Test
    fun drawing_fillsRoughlyTheScreenWidth() {
        listOf("home", "practice", "insight", "memento", "sos", "virtue").forEach { seed ->
            val outer = generateOrrery(seed).rings.maxOf { it.radius }
            assertTrue("$seed outer ring $outer", outer in 0.75f..1.35f)
        }
    }

    @Test
    fun homeDiagram_isPinned() {
        // Guards against the generator silently changing what users see on Home.
        val drawing = generateOrrery("home")

        assertEquals(PINNED_HOME_CENTER_X, drawing.centerX, 1e-6f)
        assertEquals(PINNED_HOME_OUTER_RING, drawing.rings.maxOf { it.radius }, 1e-6f)
        assertEquals(PINNED_HOME_SATELLITES, drawing.satellites.size)
    }

    @Test
    fun centre_staysNearTheMiddle() {
        val drawing = generateOrrery("memento")

        assertTrue(drawing.centerX in 0.4f..0.6f)
    }

    private companion object {
        const val PINNED_HOME_CENTER_X = 0.45057738f
        const val PINNED_HOME_OUTER_RING = 0.9648912f
        const val PINNED_HOME_SATELLITES = 5
    }
}
