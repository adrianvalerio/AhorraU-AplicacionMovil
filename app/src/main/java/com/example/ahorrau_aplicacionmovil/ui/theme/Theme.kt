package com.example.ahorrau_aplicacionmovil.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// === ESQUEMAS DE COLOR ===
private val LightColorScheme = lightColorScheme(
    primary = YellowPrimary,
    onPrimary = GrayDark,
    secondary = PinkPrimary,
    onSecondary = GrayDark,
    tertiary = GreenSuccess,
    background = White,
    onBackground = GrayDark,
    surface = YellowLight,
    onSurface = GrayDark,
    error = RedError,
    onError = White
)

private val DarkColorScheme = darkColorScheme(
    primary = YellowDark,
    onPrimary = White,
    secondary = PinkDark,
    onSecondary = White,
    tertiary = GreenSuccess,
    background = GrayDark,
    onBackground = White,
    surface = GrayMedium,
    onSurface = White,
    error = RedError,
    onError = White
)

// === FUNCIÓN PRINCIPAL DEL TEMA ===
@Composable
fun AhorraUTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
