package ru.madmax.autodoctestcase.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable


object Theme {
    val colors: AutoDocColors
        @Composable
        get() = LocalAutoDocColors.current

    val types: AutoDocTypes
        @Composable
        get() = LocalAutoDocTypes.current

    val shapes: AutoDocShapes
        @Composable
        get() = LocalAutoDocShapes.current
}

@Composable
fun AutodocTestCaseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        AutoDocDarkColorPalette
    } else {
        AutoDocLightColorPalette
    }

    val types = autoDocTypes

    val shapes = autoDocShapes

    CompositionLocalProvider(
        LocalAutoDocColors provides colors,
        LocalAutoDocTypes provides types,
        LocalAutoDocShapes provides shapes,
        content = content
    )
}