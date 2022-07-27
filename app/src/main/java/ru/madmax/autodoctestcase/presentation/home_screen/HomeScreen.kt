package ru.madmax.autodoctestcase.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import kotlinx.coroutines.launch
import ru.madmax.autodoctestcase.R
import ru.madmax.autodoctestcase.presentation.home_screen.component.Refresher
import ru.madmax.autodoctestcase.presentation.home_screen.component.RepositoryCard
import ru.madmax.autodoctestcase.ui.theme.Theme
import ru.madmax.autodoctestcase.util.PARAM_APP_TYPE
import ru.madmax.autodoctestcase.util.Screen

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    imageLoader: ImageLoader,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState = viewModel.homeState.value
    val lazyState = rememberLazyListState()
    val coroutine = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Главная",
                        color = Theme.colors.topBarTitleColor,
                        style = Theme.types.topBarTitleText
                    )
                },
                elevation = 7.dp,
                backgroundColor = Theme.colors.barColor
            )
        },
        floatingActionButton = {
            if (viewModel.homeState.value.isShowFab)
                FloatingActionButton(
                    onClick = {
                        viewModel.onEvent(HomeEvent.DismissFab)
                        coroutine.launch {
                            lazyState.animateScrollToItem(0)
                        }
                    },
                    backgroundColor = Theme.colors.barIconColor
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_up_arrow),
                        contentDescription = null
                    )
                }
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
                .background(Theme.colors.primaryBackgroundColor)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 11.dp),
                value = viewModel.queryTextFieldState.value,
                shape = Theme.shapes.mainShape,
                maxLines = 1,
                textStyle = Theme.types.textFieldText,
                placeholder = {
                    Text(
                        text = "Repository",
                        color = Theme.colors.textFieldHintColor,
                        style = Theme.types.textFieldHint
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Theme.colors.textFieldBackgroundColor,
                    focusedIndicatorColor = Theme.colors.textFieldBackgroundColor,
                    unfocusedIndicatorColor = Theme.colors.textFieldBackgroundColor,
                    placeholderColor = Theme.colors.textFieldHintColor,
                    textColor = Theme.colors.textFieldTextColor,
                    cursorColor = Theme.colors.barIconColor
                ),
                trailingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(40.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "",
                        tint = Theme.colors.textFieldTextColor
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        viewModel.onEvent(HomeEvent.Search)
                    }
                ),
                onValueChange = { query ->
                    viewModel.onEvent(HomeEvent.EnterQuery(query))
                }
            )
            Box(
                Modifier
                    .fillMaxSize()
            ) {
                Refresher(
                    isNeedToRefresh = homeState.isError,
                    isRefresh = homeState.isRefresh,
                    onRefresh = {
                        viewModel.refresh()
                    },
                    content = {
                        LazyColumn(
                            state = lazyState
                        ) {
                            items(homeState.items.size) { i ->
                                val repository = homeState.items[i]
                                if (i >= homeState.items.size - 10 && !homeState.endReached && !homeState.isLoading) {
                                    viewModel.loadNextItems()
                                }
                                if (i >= 10) {
                                    viewModel.onEvent(HomeEvent.ShowFab)
                                }
                                RepositoryCard(
                                    repository = repository,
                                    imageLoader = imageLoader,
                                    onClick = {
                                        if (PARAM_APP_TYPE == "full")
                                            navController.navigate(Screen.Owner.route + "/${repository.owner_name}")
                                    }
                                )
                                if (i < homeState.items.size - 1) {
                                    Spacer(modifier = Modifier.height(20.dp))
                                }
                            }
                            item {
                                Spacer(modifier = Modifier.height(90.dp))
                            }
                        }
                    }
                )
                if (homeState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                }
            }
        }
    }
}