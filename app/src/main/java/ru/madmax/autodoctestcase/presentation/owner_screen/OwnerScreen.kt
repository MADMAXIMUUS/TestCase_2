package ru.madmax.autodoctestcase.presentation.owner_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
    ownerViewModel.loadOwnerDetails(ownerLogin)
    val state = ownerViewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBar(
            title = { },
            navigationIcon = {
                IconButton(
                    modifier = Modifier
                        .size(40.dp),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize(),
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "",
                        tint = Theme.colors.barIconColor
                    )
                }
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
                    .size(100.dp)
                    .clip(Theme.shapes.photoShape),
                painter = rememberAsyncImagePainter(
                    model = state.owner.avatar_url,
                    imageLoader = imageLoader
                ),
                contentDescription = ""
            )
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = state.owner.login,
                    color = Theme.colors.headerTextColor,
                    style = Theme.types.headerText
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .padding(start = 5.dp),
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
                        text = "${state.owner.followers} followers",
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
                        text = "${state.owner.following} following",
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
            text = "Bio",
            style = Theme.types.sectionTitleText,
            color = Theme.colors.sectionTitleColor
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 11.dp),
            text = state.owner.bio,
            style = Theme.types.descriptionText,
            color = Theme.colors.descriptionColor
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 11.dp),
            text = "Links",
            style = Theme.types.sectionTitleText,
            color = Theme.colors.sectionTitleColor
        )
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 11.dp)
        ) {
            if (state.owner.twitter_username.isNotEmpty()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_twitter),
                        contentDescription = ""
                    )
                    Text(
                        text = "https://twitter.com/${state.owner.twitter_username}",
                        style = Theme.types.linkText,
                        color = Theme.colors.linkTextColor,
                        modifier = Modifier
                            .padding(start = 11.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
            if (state.owner.blog.isNotEmpty())
                Row(
                    modifier = Modifier.padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_internet),
                        tint = Theme.colors.descriptionColor,
                        contentDescription = ""
                    )
                    Text(
                        text = state.owner.blog,
                        color = Theme.colors.linkTextColor,
                        style = Theme.types.linkText,
                        modifier = Modifier
                            .padding(start = 11.dp)
                    )
                }
        }
    }
}