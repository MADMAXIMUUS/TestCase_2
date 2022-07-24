package ru.madmax.autodoctestcase.presentation.home_screen

sealed class HomeEvent {
    object Search : HomeEvent()
    object ShowFab : HomeEvent()
    object DismissFab : HomeEvent()
    data class EnterQuery(val query: String) : HomeEvent()
}
