package ru.madmax.autodoctestcase.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.ImageLoader
import ru.madmax.autodoctestcase.presentation.about_screen.AboutScreen
import ru.madmax.autodoctestcase.presentation.home_screen.HomeScreen
import ru.madmax.autodoctestcase.presentation.owner_screen.OwnerScreen
import ru.madmax.autodoctestcase.ui.theme.Theme


@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    paddingValues: PaddingValues,
    imageLoader: ImageLoader
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = Theme.colors.primaryBackgroundColor)
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                scaffoldState,
                imageLoader,
                navController
            )
        }
        composable(Screen.About.route) {
            AboutScreen()
        }
        composable(Screen.Owner.route + "/{username}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                }
            )) {
            val username = it.arguments?.getString("username")!!
            OwnerScreen(
                imageLoader = imageLoader,
                navController = navController,
                ownerLogin = username
            )
        }
    }
}