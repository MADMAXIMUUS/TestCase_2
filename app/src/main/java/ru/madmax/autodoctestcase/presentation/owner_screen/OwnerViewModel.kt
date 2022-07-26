package ru.madmax.autodoctestcase.presentation.owner_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.madmax.autodoctestcase.domain.use_case.GitHubUseCases
import ru.madmax.autodoctestcase.util.Resource
import javax.inject.Inject

@HiltViewModel
class OwnerViewModel @Inject constructor(
    private val gitHubUseCases: GitHubUseCases
) : ViewModel() {

    private val _state = mutableStateOf(OwnerState())
    val state: State<OwnerState> = _state

    fun loadOwnerDetails(login: String) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoading = true
            )
            when(val result = gitHubUseCases.getUserUseCase(login)) {
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        owner = result.data!!,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }


}