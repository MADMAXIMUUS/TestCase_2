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

        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0
        )

        val placeables = measurables.map { measurable ->
            measurable.measure(looseConstraints)
        }


        var maxHeight = placeables.maxOfOrNull { it.height } ?: 0
        var x = 0
        placeables.forEach { placeable ->
            if (x + placeable.width > constraints.maxWidth) {
                maxHeight += placeable.height + 10
                x = 0
            }
            x += placeable.width
        }

        layout(constraints.maxWidth, maxHeight) {

            var yPosition = 0
            var xPosition = 0

            placeables.forEach { placeable ->

                if (xPosition + placeable.width > constraints.maxWidth) {
                    yPosition += placeable.height + 10
                    xPosition = 0
                }

                placeable.place(x = xPosition, y = yPosition)

                xPosition += placeable.width
            }
        }
    }
}