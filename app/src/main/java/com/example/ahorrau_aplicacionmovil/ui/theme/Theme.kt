package com.example.ahorrau_aplicacionmovil.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = YellowPrimary,
    onPrimary = White,
    secondary = PinkPrimary,
    onSecondary = White,
    background = YellowPrimary,
    onBackground = GrayDark,
    surface = White,
    onSurface = GrayDark
)

private val DarkColors = darkColorScheme(
    primary = YellowPrimary,
    onPrimary = White,
    secondary = PinkPrimary,
    onSecondary = White,
    background = GrayDark,
    onBackground = White,
    surface = GrayDark,
    onSurface = White
)

@Composable
fun AhorraUTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
