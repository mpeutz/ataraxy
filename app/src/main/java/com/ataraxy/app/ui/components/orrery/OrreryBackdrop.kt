package com.ataraxy.app.ui.components.orrery

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

/** How strongly the pattern shows: a fraction of the theme's text colour. */
private const val PATTERN_ALPHA = 0.055f
private const val NESTED_SATELLITE_SCALE = 0.45f

@Immutable
class OrreryPattern internal constructor(
    val drawing: OrreryDrawing,
    val background: Color,
    val line: Color,
    val centerY: Float
)

/**
 * The orrery diagram for one screen. Each screen passes its own [seed], so its diagram is unique
 * to it and never changes. [centerY] places the centre as a fraction of the height, ideally
 * behind the screen's quote.
 */
@Composable
fun rememberOrreryPattern(seed: String, centerY: Float = 0.45f): OrreryPattern {
    val drawing = remember(seed) { generateOrrery(seed) }
    val background = MaterialTheme.colorScheme.background
    val line = MaterialTheme.colorScheme.onBackground.copy(alpha = PATTERN_ALPHA)
    return remember(drawing, background, line, centerY) { OrreryPattern(drawing, background, line, centerY) }
}

/**
 * Paints the screen background with the orrery drawn quietly behind the content. Use it in place
 * of `background(...)` on a screen's root container. The diagram stays put while content scrolls.
 */
fun Modifier.orreryBackground(pattern: OrreryPattern): Modifier =
    clipToBounds().drawWithCache {
        val stroke = Stroke(width = 0.8.dp.toPx())
        val center = Offset(pattern.drawing.centerX * size.width, pattern.centerY * size.height)
        onDrawBehind {
            drawRect(pattern.background)
            drawOrrery(pattern.drawing, center, size.width, pattern.line, stroke)
        }
    }

private fun DrawScope.drawOrrery(drawing: OrreryDrawing, center: Offset, scale: Float, color: Color, stroke: Stroke) {
    fun Point.toOffset() = Offset(center.x + x * scale, center.y + y * scale)

    drawing.rings.forEach { drawCircle(color, it.radius * scale, center, style = stroke) }
    drawing.arcs.forEach { arc ->
        val r = arc.radius * scale
        drawArc(
            color = color,
            startAngle = arc.startDegrees - 90f,
            sweepAngle = arc.sweepDegrees,
            useCenter = false,
            topLeft = Offset(center.x - r, center.y - r),
            size = Size(r * 2, r * 2),
            style = stroke
        )
    }
    drawing.lines.forEach { drawLine(color, it.start.toOffset(), it.end.toOffset(), stroke.width) }
    drawing.satellites.forEach { satellite ->
        val c = satellite.center.toOffset()
        drawCircle(color, satellite.radius * scale, c, style = stroke)
        if (satellite.nested) drawCircle(color, satellite.radius * scale * NESTED_SATELLITE_SCALE, c, style = stroke)
    }
    drawing.dots.forEach { drawCircle(color, it.radius * scale, it.center.toOffset()) }
}
