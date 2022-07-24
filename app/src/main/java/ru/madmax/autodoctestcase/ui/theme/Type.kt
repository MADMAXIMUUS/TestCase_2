package ru.madmax.autodoctestcase.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import ru.madmax.autodoctestcase.R

val BloggerSans = FontFamily(
    Font(R.font.blogger_sans_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.blogger_sans_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.blogger_sans_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.blogger_sans_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.blogger_sans_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.blogger_sans_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.blogger_sans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.blogger_sans, FontWeight.Normal, FontStyle.Normal)
)

data class AutoDocTypes(
    val topBarTitleText: TextStyle,
    val bottomBarText: TextStyle,
    val cardTitleText: TextStyle,
    val cardDescriptionText: TextStyle,
    val cardDateText: TextStyle,
    val cardTagText: TextStyle,
    val cardStarText: TextStyle,
    val textFieldText: TextStyle,
    val textFieldHint: TextStyle,
    val headerText: TextStyle,
    val aboutMessageText: TextStyle,
    val descriptionText: TextStyle,
    val linkText: TextStyle,
    val followText: TextStyle,
    val sectionTitleText: TextStyle
)

val autoDocTypes = AutoDocTypes(
    topBarTitleText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 26.sp
    ),
    bottomBarText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp
    ),
    cardTitleText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp
    ),
    cardDescriptionText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp
    ),
    cardDateText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp
    ),
    cardTagText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp
    ),
    cardStarText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp
    ),
    textFieldText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp
    ),
    textFieldHint = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp
    ),
    headerText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 22.sp
    ),
    aboutMessageText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp
    ),
    descriptionText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Justify,
        fontSize = 14.sp
    ),
    linkText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        textDecoration = TextDecoration.Underline,
        fontSize = 16.sp
    ),
    followText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp
    ),
    sectionTitleText = TextStyle(
        fontFamily = BloggerSans,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp
    )
)

val LocalAutoDocTypes = staticCompositionLocalOf<AutoDocTypes> {
    error("No font provided")
}