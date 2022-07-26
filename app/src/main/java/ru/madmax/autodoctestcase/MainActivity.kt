package ru.madmax.autodoctestcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import dagger.hilt.android.AndroidEntryPoint
import ru.madmax.autodoctestcase.util.Navigation
import ru.madmax.autodoctestcase.ui.theme.AutodocTestCaseTheme
import ru.madmax.autodoctestcase.ui.theme.Theme
import ru.madmax.autodoctestcase.util.Screen
import javax.inject.Inject

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutodocTestCaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Theme.colors.primaryBackgroundColor
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val scaffoldState = rememberScaffoldState()
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        bottomBar = {
                            if (shouldShowBottomBar(navBackStackEntry)) {
                                BottomAppBar(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    elevation = 7.dp,
                                    cutoutShape = CircleShape,
                                    backgroundColor = Theme.colors.barColor,
                                ) {
                                    BottomNavigation(
                                        backgroundColor = Theme.colors.barColor
                                    ) {
                                        BottomNavigationItem(
                                            icon = {
                                                Column(
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.ic_home),
                                                        contentDescription = null
                                                    )
                                                    Text(text = getString(R.string.bottom_main))
                                                }
                                            },
                                            selectedContentColor = Theme.colors.barTitleSelectedColor,
                                            unselectedContentColor = Theme.colors.barTitleUnselectedColor,
                                            selected = navController.currentDestination?.route?.startsWith(
                                                Screen.Home.route
                                            ) == true,
                                            onClick = {
                                                if (navController.currentDestination?.route != Screen.Home.route) {
                                                    navController.navigate(Screen.Home.route)
                                                }
                                            }
                                        )
                                        BottomNavigationItem(
                                            icon = {
                                                Column(
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.ic_about),
                                                        contentDescription = null
                                                    )
                                                    Text(text = getString(R.string.bottom_about))
                                                }
                                            },
                                            selectedContentColor = Theme.colors.barTitleSelectedColor,
                                            unselectedContentColor = Theme.colors.barTitleUnselectedColor,
                                            selected = navController.currentDestination?.route?.startsWith(
                                                Screen.About.route
                                            ) == true,
                                            onClick = {
                                                if (navController.currentDestination?.route != Screen.About.route) {
                                                    navController.navigate(Screen.About.route)
                                                }
                                            }
                                        )
                                    }
                                }
                            }
                        },
                        content = { padding ->
                            Navigation(navController, padding, imageLoader)
                        },
                        scaffoldState = scaffoldState
                    )
                }
            }
        }
    }

    private fun shouldShowBottomBar(backStackEntry: NavBackStackEntry?): Boolean {
        return backStackEntry?.destination?.route in listOf(
            Screen.Home.route,
            Screen.About.route
        )
    }
}