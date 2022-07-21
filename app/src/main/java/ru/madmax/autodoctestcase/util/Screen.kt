package ru.madmax.autodoctestcase.util

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object About: Screen("about")
    object Owner: Screen("owner")
}