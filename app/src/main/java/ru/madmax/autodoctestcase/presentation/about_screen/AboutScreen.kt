package ru.madmax.autodoctestcase.presentation.about_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import ru.madmax.autodoctestcase.R
import ru.madmax.autodoctestcase.ui.theme.Theme

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(
                    "О программе",
                    color = Theme.colors.topBarTitleColor,
                    style = Theme.types.topBarTitleText
                )
            },
            elevation = 7.dp,
            backgroundColor = Theme.colors.barColor
        )
        Spacer(modifier = Modifier.height(25.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
                .clip(Theme.shapes.mainShape),
            painter = painterResource(
                id = if (isSystemInDarkTheme())
                    R.drawable.about_dark
                else
                    R.drawable.about
            ),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = stringResource(id = R.string.about_description),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            textAlign = TextAlign.Center,
            style = Theme.types.aboutMessageText,
            color = Theme.colors.descriptionColor
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Автор: Максим Нечаев",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp),
            textAlign = TextAlign.Center,
            color = Theme.colors.descriptionColor,
            style = Theme.types.aboutMessageText
        )
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_telegram),
                    contentDescription = ""
                )
                Text(
                    text = "https://t.me/MAD_MAXIMUUS",
                    style = Theme.types.linkText,
                    color = Theme.colors.linkTextColor,
                    modifier = Modifier
                        .padding(start = 11.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_github),
                    contentDescription = ""
                )
                Text(
                    text = "https://github.com/MADMAXIMUUS",
                    color = Theme.colors.linkTextColor,
                    style = Theme.types.linkText,
                    modifier = Modifier
                        .padding(start = 11.dp)
                )
            }
        }
    }
}