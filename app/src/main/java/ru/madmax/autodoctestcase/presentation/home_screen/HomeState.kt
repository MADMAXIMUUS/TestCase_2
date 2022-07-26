package ru.madmax.autodoctestcase.presentation.home_screen

import ru.madmax.autodoctestcase.domain.models.RepositoryItem

data class HomeState(
    val items: List<RepositoryItem> = emptyList(),
    val isLoading: Boolean = false,
    val isRefresh: Boolean = false,
    val endReached: Boolean = false,
    val isShowFab: Boolean = false,
    val isError: Boolean = false
)
