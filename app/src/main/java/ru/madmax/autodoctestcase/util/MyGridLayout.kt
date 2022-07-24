package ru.madmax.autodoctestcase.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun MyGridLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            var yPosition = 0
            var xPosition = 0

            placeables.forEach { placeable ->

                if (xPosition + placeable.measuredWidth > constraints.maxWidth) {
                    yPosition += placeable.measuredHeight
                    xPosition = 0
                }

                placeable.place(x = xPosition, y = yPosition)

                xPosition += placeable.measuredWidth
            }
        }
    }
}