package ru.madmax.autodoctestcase.presentation.owner_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.madmax.autodoctestcase.domain.use_case.GitHubUseCases
import javax.inject.Inject

@HiltViewModel
class OwnerViewModel @Inject constructor(
    private val gitHubUseCases: GitHubUseCases
) : ViewModel() {

}