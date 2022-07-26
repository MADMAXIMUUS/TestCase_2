package ru.madmax.autodoctestcase.presentation.owner_screen

import ru.madmax.autodoctestcase.domain.models.OwnerDetails

data class OwnerState(
    val isLoading: Boolean = false,
    val owner: OwnerDetails = OwnerDetails()
)
