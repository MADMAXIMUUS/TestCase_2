package ru.madmax.autodoctestcase.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.madmax.autodoctestcase.domain.models.RepositoryItem
import ru.madmax.autodoctestcase.domain.use_case.GitHubUseCases
import ru.madmax.autodoctestcase.util.RepositoriesPaginator
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val gitHubUseCases: GitHubUseCases
) : ViewModel() {

    private val _queryTextFieldState = mutableStateOf("")
    val queryTextFieldState: State<String> = _queryTextFieldState

    private val _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState> = _homeState

    private val paginator = RepositoriesPaginator(
        onLoadUpdated = { isLoading ->
            _homeState.value = homeState.value.copy(
                isLoading = isLoading
            )
        },
        onRequest = { page ->
            gitHubUseCases.getRepositoriesUseCase(
                query = _queryTextFieldState.value,
                page = page
            )
        },
        onSuccess = { posts ->
            _homeState.value = homeState.value.copy(
                items = homeState.value.items + posts,
                endReached = posts.isEmpty(),
                isLoading = false
            )
        },
        onError = { message ->

        }
    )

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.DismissFab -> {
                _homeState.value = _homeState.value.copy(
                    isShowFab = false
                )
            }
            is HomeEvent.EnterQuery -> {
                _queryTextFieldState.value = event.query
            }
            HomeEvent.Search -> {
                loadNextPosts()
            }
            HomeEvent.ShowFab -> {
                _homeState.value = _homeState.value.copy(
                    isShowFab = true
                )
            }
        }
    }

    fun loadNextPosts() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }
}