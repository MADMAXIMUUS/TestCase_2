package ru.madmax.autodoctestcase.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Dark_Charcoal = Color(0xFF333333)
val Lotion = Color(0xFFFAFAFA)
val Cultured = Color(0xFFF5F5F5)
val Cyan_Blue_Azure = Color(0xFF4078C0)
val Burnt_Orange = Color(0xFFC9510C)
val Spanish_Gray = Color(0xFF979797)
val Dim_Gray = Color(0xFF686868)
val Chinese_White = Color(0xFFE1E1E1)
val American_Yellow = Color(0xFFEDB408)
val Onyx = Color(0xFF393939)
val Apple = Color(0xFF6CC644)
val Philippine_Gray = Color(0xFF909090)
val Chinese_Black = Color(0xFF121212)

data class AutoDocColors(
    val primaryBackgroundColor: Color,
    val cardBackgroundColor: Color,
    val barColor: Color,
    val headerTextColor: Color,
    val descriptionColor: Color,
    val cardHeaderTextColor: Color,
    val cardDescriptionTextColor: Color,
    val cardDateTextColor: Color,
    val cardStarTextColor: Color,
    val cardTagBackgroundColor: Color,
    val cardTagTextColor: Color,
    val barTitleSelectedColor: Color,
    val barTitleUnselectedColor: Color,
    val topBarTitleColor: Color,
    val textFieldBackgroundColor: Color,
    val textFieldTextColor: Color,
    val textFieldHintColor: Color,
)

val AutoDocDarkColorPalette = AutoDocColors(
    primaryBackgroundColor = Chinese_Black,
    cardBackgroundColor = Onyx,
    barColor = Dark_Charcoal,
    headerTextColor = Apple,
    descriptionColor = Chinese_White,
    cardHeaderTextColor = Cultured,
    cardDescriptionTextColor = Philippine_Gray,
    cardDateTextColor = Spanish_Gray,
    cardStarTextColor = American_Yellow,
    cardTagBackgroundColor = Chinese_Black,
    cardTagTextColor = Apple,
    barTitleSelectedColor = Apple,
    barTitleUnselectedColor = Lotion,
    topBarTitleColor = Apple,
    textFieldBackgroundColor = Onyx,
    textFieldTextColor = Lotion,
    textFieldHintColor = Spanish_Gray,
)

val AutoDocLightColorPalette = AutoDocColors(
    primaryBackgroundColor = Color(0xFFFFFFFF),
    cardBackgroundColor = Cultured,
    barColor = Lotion,
    headerTextColor = Apple,
    descriptionColor = Color(0xFF000000),
    cardHeaderTextColor = Dark_Charcoal,
    cardDescriptionTextColor = Dim_Gray,
    cardDateTextColor = Spanish_Gray,
    cardStarTextColor = American_Yellow,
    cardTagBackgroundColor = Chinese_White,
    cardTagTextColor = Cyan_Blue_Azure,
    barTitleSelectedColor = Burnt_Orange,
    barTitleUnselectedColor = Cyan_Blue_Azure,
    topBarTitleColor = Cyan_Blue_Azure,
    textFieldBackgroundColor = Cultured,
    textFieldTextColor = Dark_Charcoal,
    textFieldHintColor = Philippine_Gray
)

val LocalAutoDocColors = staticCompositionLocalOf<AutoDocColors> {
    error("No colors provided")
}