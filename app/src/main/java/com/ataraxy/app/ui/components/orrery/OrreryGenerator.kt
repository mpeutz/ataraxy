package com.ataraxy.app.ui.components.orrery

import kotlin.math.cos
import kotlin.math.sin

/**
 * An orrery-style line diagram. Sizes and positions are fractions of the container width;
 * points are relative to the diagram centre, which sits at [centerX] across the container.
 */
data class OrreryDrawing(
    val centerX: Float,
    val rings: List<Ring>,
    val arcs: List<Arc>,
    val lines: List<Line>,
    val satellites: List<Satellite>,
    val dots: List<Dot>
)

data class Point(val x: Float, val y: Float)
data class Ring(val radius: Float)
data class Arc(val radius: Float, val startDegrees: Float, val sweepDegrees: Float)
data class Line(val start: Point, val end: Point)
data class Satellite(val center: Point, val radius: Float, val nested: Boolean)
data class Dot(val center: Point, val radius: Float)

// The rules below are written in design units; this scales them so the outermost ring
// lands close to the screen width ("filling").
private const val UNIT = 1.95f / 300f

private val AXIS_ANGLES = listOf(0f, 45f, 90f, 135f)

/** Builds the diagram for [seed]. The same seed always yields the same drawing. */
fun generateOrrery(seed: String): OrreryDrawing {
    val rnd = SplitMix(seed.hashCode().toLong())
    val radii = buildList {
        var r = 14f
        add(r)
        repeat(5) {
            r += rnd.between(22f, 34f)
            add(r)
        }
    }
    val outer = radii.last()

    val rings = buildList {
        radii.forEachIndexed { i, r ->
            add(Ring(r))
            if (i >= 2 && rnd.nextFloat() < 0.45f) add(Ring(r + 4f))
        }
    }

    val arcs = List(3) { k ->
        Arc(radius = outer + 10f + 9f * k, startDegrees = rnd.between(0f, 360f), sweepDegrees = rnd.between(60f, 150f))
    }

    val lines = mutableListOf<Line>()
    val firstAxis = rnd.nextInt(0, AXIS_ANGLES.size)
    val secondAxis = (firstAxis + 1 + rnd.nextInt(0, AXIS_ANGLES.size - 1)) % AXIS_ANGLES.size
    listOf(AXIS_ANGLES[firstAxis], AXIS_ANGLES[secondAxis]).forEach { a ->
        lines += Line(polar(outer + 6f, a), polar(outer + 6f, a + 180f))
    }
    val ray = rnd.between(20f, 70f)
    lines += Line(polar(radii[1], ray), polar(outer, ray))

    val count = rnd.nextInt(4, 6)
    val satellites = List(count) { k ->
        val ring = radii[rnd.nextInt(1, radii.size)]
        val angle = 360f / count * k + rnd.between(-40f, 40f)
        Satellite(polar(ring, angle), rnd.between(6f, 15f), nested = rnd.nextFloat() < 0.5f)
    }
    satellites.zipWithNext().take(2).forEach { (a, b) -> lines += Line(a.center, b.center) }

    val dots = buildList {
        repeat(4) {
            val ring = radii.drop(2)[rnd.nextInt(0, radii.size - 2)]
            val angle = rnd.between(0f, 360f)
            add(Dot(polar(ring, angle), 1.6f))
            add(Dot(polar(ring, angle + 3.5f), 1.6f))
        }
    }

    return OrreryDrawing(
        centerX = 0.5f + rnd.between(-0.05f, 0.05f),
        rings = rings.map { Ring(it.radius * UNIT) },
        arcs = arcs.map { it.copy(radius = it.radius * UNIT) },
        lines = lines.map { Line(it.start.scaled(), it.end.scaled()) },
        satellites = satellites.map { it.copy(center = it.center.scaled(), radius = it.radius * UNIT) },
        dots = dots.map { it.copy(center = it.center.scaled(), radius = it.radius * UNIT) }
    )
}

/** A point at [radius] and [degrees] clockwise from twelve o'clock. */
private fun polar(radius: Float, degrees: Float): Point {
    val rad = Math.toRadians((degrees - 90f).toDouble())
    return Point((radius * cos(rad)).toFloat(), (radius * sin(rad)).toFloat())
}

private fun Point.scaled() = Point(x * UNIT, y * UNIT)

/**
 * SplitMix64. Used instead of kotlin.random so each screen's diagram can't change when the
 * Kotlin standard library does.
 */
private class SplitMix(private var state: Long) {
    fun nextLong(): Long {
        state += -0x61c8864680b583ebL
        var z = state
        z = (z xor (z ushr 30)) * -0x40a7b892e31b1a47L
        z = (z xor (z ushr 27)) * -0x6b2fb644ecceee15L
        return z xor (z ushr 31)
    }

    fun nextFloat(): Float = (nextLong() ushr 40).toFloat() / (1 shl 24)

    fun between(from: Float, until: Float): Float = from + (until - from) * nextFloat()

    fun nextInt(from: Int, until: Int): Int = from + ((nextLong() ushr 1) % (until - from)).toInt()
}
