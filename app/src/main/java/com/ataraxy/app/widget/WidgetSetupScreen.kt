package com.ataraxy.app.widget

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.ataraxy.app.R
import com.ataraxy.app.domain.model.AppTheme
import com.ataraxy.app.ui.theme.AtaraxyText
import com.ataraxy.app.ui.theme.WidgetType

private const val PREVIEW_HEIGHT_DP = 140
private val WALLPAPER = Color(0xFF7A7F87)
private val CLEAR_SHADOW = Shadow(Color(0x80000000), Offset(0f, 1f), 6f)

@Composable
fun WidgetSetupScreen(viewModel: WidgetSetupViewModel, onSave: () -> Unit) {
    val selected by viewModel.selected.collectAsState()
    val alreadyAdded by viewModel.alreadyAdded.collectAsState()
    val loaded by viewModel.loaded.collectAsState()
    val quote by viewModel.quote.collectAsState()
    val prefs by viewModel.userPrefs.collectAsState()
    val saving by viewModel.saving.collectAsState()

    val look = resolveLook(selected, prefs?.theme ?: AppTheme.SYSTEM, isSystemInDarkTheme())
    val quoteText = quote?.text ?: stringResource(R.string.widget_empty)
    val author = quote?.let { "— ${it.authorName.uppercase()}" }.orEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = stringResource(R.string.widget_setup_title).uppercase(),
            style = AtaraxyText.screenTitle,
            color = MaterialTheme.colorScheme.onBackground
        )
        WidgetPreview(look, quoteText, author)
        Column(Modifier.selectableGroup()) {
            viewModel.styles.forEach { style ->
                StyleOption(style, style == selected, loaded) { viewModel.select(style) }
            }
        }
        Button(
            onClick = onSave,
            enabled = loaded && !saving,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            val label = if (alreadyAdded) R.string.widget_setup_save_reconfigure else R.string.widget_setup_save
            Text(text = stringResource(label), style = AtaraxyText.button)
        }
    }
}

@Composable
private fun StyleOption(style: WidgetStyle, isSelected: Boolean, enabled: Boolean, onSelect: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(selected = isSelected, enabled = enabled, onClick = onSelect, role = Role.RadioButton)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = stringResource(styleLabel(style)),
            style = AtaraxyText.body,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@StringRes
private fun styleLabel(style: WidgetStyle): Int = when (style) {
    WidgetStyle.MATCH_APP -> R.string.widget_style_match_app
    WidgetStyle.LIGHT -> R.string.widget_style_light
    WidgetStyle.DARK -> R.string.widget_style_dark
    WidgetStyle.CLEAR -> R.string.widget_style_clear
    WidgetStyle.ACCENT -> R.string.widget_style_accent
}

@Composable
private fun WidgetPreview(look: WidgetLook, quoteText: String, author: String) {
    val isClear = look.layout == WidgetLayout.CLEAR
    val spec = quoteTextSpec(PREVIEW_HEIGHT_DP)
    val shadow = if (isClear) CLEAR_SHADOW else null
    val quoteStyle = TextStyle(
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
        fontSize = spec.sizeSp.sp,
        color = colorResource(look.quoteColor),
        shadow = shadow
    )
    val authorStyle = AtaraxyText.meta.copy(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = WidgetType.AUTHOR_SP.sp,
        letterSpacing = 0.2.em,
        color = colorResource(look.authorColor),
        shadow = shadow
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .then(if (isClear) Modifier.background(WALLPAPER, MaterialTheme.shapes.large) else Modifier)
            .padding(if (isClear) 16.dp else 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .widgetBackground(look.background)
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Text(text = quoteText, style = quoteStyle, maxLines = spec.maxLines, overflow = TextOverflow.Ellipsis)
            if (author.isNotEmpty()) Text(text = author, style = authorStyle, modifier = Modifier.padding(top = 6.dp))
        }
    }
}

/** Draws the same drawable the real widget uses, so the preview's shape and fill cannot drift from it. */
@Composable
private fun Modifier.widgetBackground(@DrawableRes drawableRes: Int?): Modifier {
    if (drawableRes == null) return this
    val drawable = ContextCompat.getDrawable(LocalContext.current, drawableRes) ?: return this
    return drawBehind {
        drawable.setBounds(0, 0, size.width.toInt(), size.height.toInt())
        drawIntoCanvas { drawable.draw(it.nativeCanvas) }
    }
}
