package ru.madmax.autodoctestcase.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

data class AutoDocShapes(
    val mainShape: Shape,
    val cardTagShape: Shape,
    val photoShape: Shape
)

val autoDocShapes = AutoDocShapes(
    mainShape = RoundedCornerShape(15.dp),
    cardTagShape = RoundedCornerShape(5.dp),
    photoShape = CircleShape
)


val LocalAutoDocShapes = staticCompositionLocalOf<AutoDocShapes> {
    error("No shapes provided")
}