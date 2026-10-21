package com.ataraxy.app.ui.theme

import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

/**
 * Keeps text styling in one place: screens must take their text style from [AtaraxyText] rather
 * than setting sizes, spacing, fonts or raw Material styles themselves. Scans the whole app, so
 * screens outside ui/ (such as the widget's setup screen) are held to the same rule.
 */
class TypographyGuardTest {

    private val appRoot = File("src/main/java/com/ataraxy/app")
    private val forbidden = listOf(
        Regex("""\bfontSize\s*="""),
        Regex("""\blineHeight\s*="""),
        Regex("""\bletterSpacing\s*="""),
        Regex("""\bfontFamily\s*="""),
        Regex("""MaterialTheme\.typography"""),
        Regex("""\bTextStyle\("""),
        Regex("""\.(sp|em)\b"""),
        Regex("""\b(ProvideTextStyle|LocalTextStyle)\b""")
    )

    @Test
    fun screensUseTextRolesOnly() {
        assertTrue("App sources not found at ${appRoot.absolutePath}", appRoot.isDirectory)
        val screens = appRoot.walkTopDown()
            .filter { it.isFile && it.extension == "kt" && !it.invariantSeparatorsPath.contains("/ui/theme/") }
            .toList()
        assertTrue("No screens found under ${appRoot.absolutePath}", screens.size > 10)

        val hits = screens
            .flatMap { file ->
                file.readLines().mapIndexedNotNull { index, line ->
                    if (forbidden.any { it.containsMatchIn(line) }) "${file.relativeTo(appRoot).invariantSeparatorsPath}:${index + 1}" else null
                }
            }
            .toList()

        assertTrue("${hits.size} ad hoc text styles outside ui/theme:\n" + hits.joinToString("\n"), hits.isEmpty())
    }
}
