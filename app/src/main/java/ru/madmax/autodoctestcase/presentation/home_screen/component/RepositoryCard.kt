package ru.madmax.autodoctestcase.presentation.home_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import ru.madmax.autodoctestcase.R
import ru.madmax.autodoctestcase.domain.models.RepositoryItem
import ru.madmax.autodoctestcase.ui.theme.Theme

@ExperimentalMaterialApi
@Composable
fun RepositoryCard(
    imageLoader: ImageLoader,
    repository: RepositoryItem,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        backgroundColor = Theme.colors.cardBackgroundColor,
        shape = Theme.shapes.mainShape,
        onClick = { onClick(repository.owner_name) }
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp, 11.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(bottom = 11.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .clip(Theme.shapes.photoShape)
                        .size(40.dp),
                    painter = rememberAsyncImagePainter(
                        model = repository.owner_avatar_url,
                        imageLoader = imageLoader
                    ),
                    contentDescription = "Owner avatar",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(start = 11.dp),
                    text = repository.name,
                    style = Theme.types.cardTitleText,
                    overflow = TextOverflow.Ellipsis,
                    color = Theme.colors.cardTitleTextColor
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "",
                    tint = Theme.colors.cardStarTextColor
                )
                Text(
                    text = repository.star.toString(),
                    style = Theme.types.cardStarText,
                    color = Theme.colors.cardStarTextColor
                )
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = repository.description,
                textAlign = TextAlign.Justify,
                style = Theme.types.descriptionText,
                color = Theme.colors.descriptionColor
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 11.dp)
            ) {
                repository.languages.forEach {
                    Language(language = it)
                }
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = repository.lastUpdateDate,
                textAlign = TextAlign.Center,
                style = Theme.types.cardDateText,
                color = Theme.colors.cardDateTextColor
            )
        }
    }
}

@Composable
fun Language(language: String) {
    Box(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(end = 5.dp)
            .clip(Theme.shapes.cardTagShape)
            .background(Theme.colors.cardTagBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .padding(5.dp),
            text = language,
            style = Theme.types.cardTagText,
            color = Theme.colors.cardTagTextColor
        )
    }
}