package com.rcalderon.jetpackcomposematerial3.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {

    @Serializable
    object MainScreen : Routes("main_screen")

    @Serializable
    object ButtonScreen : Routes("button_screen")

    @Serializable
    object CardsScreen : Routes("cards_screen")

    @Serializable
    object ProgressIndicatorsScreen : Routes("progress_indicators_screen")

    @Serializable
    object SnackbarAndDialogScreen : Routes("snackbar_and_dialog_screen")

    @Serializable
    object AnimatedBoxScreen : Routes("basic_animations_screen")

    @Serializable
    object UiControlsScreen : Routes("ui_controls_screen")

    @Serializable
    object InfiniteListAndPullToRefreshScreen : Routes("infinite_list_and_pull_to_refresh_screen")
}
