package com.example.harjoitus_01.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Turquoise,
    onPrimary = White,

    secondary = Green,
    onSecondary = DarkBlue,

    tertiary = Red,
    onTertiary = White,

    background = DarkBlue,
    onBackground = White,

    surface = DarkBlue,
    onSurface = White
)

private val LightColorScheme = lightColorScheme(
    primary = Turquoise,
    onPrimary = White,

    secondary = Green,
    onSecondary = DarkBlue,

    tertiary = Red,
    onTertiary = White,

    background = LightBlueGrey,
    onBackground = DarkBlue,

    surface = White,
    onSurface = DarkBlue
)

@Composable
fun Harjoitus01Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}