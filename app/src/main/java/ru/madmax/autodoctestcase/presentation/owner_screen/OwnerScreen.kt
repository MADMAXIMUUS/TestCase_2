package ru.madmax.autodoctestcase.presentation.owner_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.key.Key.Companion.W
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import ru.madmax.autodoctestcase.R
import ru.madmax.autodoctestcase.ui.theme.Theme

@Composable
fun OwnerScreen(
    imageLoader: ImageLoader,
    navController: NavController,
    ownerLogin: String,
    ownerViewModel: OwnerViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = { },
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "",
                    tint = Theme.colors.barIconColor
                )
            },
            elevation = 7.dp,
            backgroundColor = Theme.colors.barColor
        )
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 11.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(Theme.shapes.photoShape),
                painter = rememberAsyncImagePainter(
                    model = "empty",
                    imageLoader = imageLoader
                ),
                contentDescription = ""
            )
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Максим",
                    color = Theme.colors.headerTextColor,
                    style = Theme.types.headerText
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(15.dp),
                        painter = painterResource(id = R.drawable.ic_follower),
                        contentDescription = "",
                        tint = Theme.colors.followTextColor
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${10} followers",
                        color = Theme.colors.followTextColor,
                        style = Theme.types.followText
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(Theme.shapes.photoShape)
                            .background(Theme.colors.followTextColor),
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        modifier = Modifier
                            .size(15.dp),
                        painter = painterResource(id = R.drawable.ic_following),
                        contentDescription = "",
                        tint = Theme.colors.followTextColor
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "${10} following",
                        color = Theme.colors.followTextColor,
                        style = Theme.types.followText
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 11.dp),
            text = "bio",
            style = Theme.types.sectionTitleText,
            color = Theme.colors.sectionTitleColor
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 11.dp),
            text = "Nunc fringilla ornare eleifend. Nullam finibus, augue nec lacinia sagittis, diam libero scelerisque diam, nec consequat velit sapien nec sem. Aliquam cursus enim dolor. Suspendisse potenti. Sed dapibus, nisl a mattis lobortis, urna lacus scelerisque eros, non elementum dolor ante non mauris. Suspendisse in maximus felis. Quisque consequat arcu sit amet purus mattis vulputate. In orci diam, semper eu nulla id, fermentum sollicitudin elit. Sed vel feugiat mauris. Phasellus sagittis enim nec odio feugiat commodo. Donec vitae blandit ante.",
            style = Theme.types.descriptionText,
            color = Theme.colors.descriptionColor
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 11.dp),
            text = "links",
            style = Theme.types.sectionTitleText,
            color = Theme.colors.sectionTitleColor
        )
        /*Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 11.dp),
            text = "Nunc fringilla ornare eleifend. Nullam finibus, augue nec lacinia sagittis, diam libero scelerisque diam, nec consequat velit sapien nec sem. Aliquam cursus enim dolor. Suspendisse potenti. Sed dapibus, nisl a mattis lobortis, urna lacus scelerisque eros, non elementum dolor ante non mauris. Suspendisse in maximus felis. Quisque consequat arcu sit amet purus mattis vulputate. In orci diam, semper eu nulla id, fermentum sollicitudin elit. Sed vel feugiat mauris. Phasellus sagittis enim nec odio feugiat commodo. Donec vitae blandit ante.",
            style = Theme.types.descriptionText,
            color = Theme.colors.descriptionColor
        )*/
    }
}