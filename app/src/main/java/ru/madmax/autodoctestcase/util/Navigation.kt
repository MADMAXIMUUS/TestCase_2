package ru.madmax.autodoctestcase.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.madmax.autodoctestcase.ui.theme.Theme
import ru.madmax.autodoctestcase.util.Screen


@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Theme.colors.primaryBackgroundColor)
    ) {
        composable(Screen.Home.route) {

        }
        composable(Screen.About.route) {

        }
        composable(Screen.Owner.route + "/{username}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                }
            )) {
            val username = it.arguments?.getString("edit")!!

        }
    }
}