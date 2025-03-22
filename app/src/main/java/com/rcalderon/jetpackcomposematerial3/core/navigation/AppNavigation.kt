package com.rcalderon.jetpackcomposematerial3.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rcalderon.jetpackcomposematerial3.presentation.screens.AnimatedBoxScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.ButtonScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.CardsScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.LazyListsAndPullRefreshScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.MainScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.ProgressIndicatorsScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.SnackBarsAndDialogsScreen
import com.rcalderon.jetpackcomposematerial3.presentation.screens.UiControlsScreen

@Composable
fun AppNavigation(
    isDarkTheme: Boolean,
    onChangeTheme: (Boolean) -> Unit,
) {
    val navController = rememberNavController()
    NavHost (navController = navController, startDestination = Routes.MainScreen.route) {
        composable(Routes.MainScreen.route) {
            MainScreen(
                isDarkTheme = isDarkTheme,
                onChangeTheme = onChangeTheme,
                onNavigate = { route ->
                    navController.navigate(
                        route = route,
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Routes.ButtonScreen.route) {
            ButtonScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Routes.CardsScreen.route) {
            CardsScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Routes.ProgressIndicatorsScreen.route) {
            ProgressIndicatorsScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Routes.SnackbarAndDialogScreen.route) {
            SnackBarsAndDialogsScreen (onNavigateBack = { navController.popBackStack() })
        }
        composable(Routes.AnimatedBoxScreen.route) {
            AnimatedBoxScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Routes.UiControlsScreen.route) {
            UiControlsScreen(onNavigateBack = { navController.popBackStack() })
        }
        composable(Routes.InfiniteListAndPullToRefreshScreen.route){
            LazyListsAndPullRefreshScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}