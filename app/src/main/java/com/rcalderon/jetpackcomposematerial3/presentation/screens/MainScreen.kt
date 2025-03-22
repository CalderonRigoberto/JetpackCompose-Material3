package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.automirrored.twotone.ExitToApp
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rcalderon.jetpackcomposematerial3.core.navigation.Routes
import com.rcalderon.jetpackcomposematerial3.presentation.components.ItemComponents


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(
    onNavigate: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Jetpack Compose + Material 3")
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ItemComponents(
                title = "Buttons",
                description = "Different types of buttons",
                icon = {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.ButtonScreen.route)
                }
            )

            ItemComponents(
                title = "Cards",
                description = "Different cards with some basics design",
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.CardsScreen.route)
                }
            )

            ItemComponents(
                title = "Progress Indicators",
                description = "Different types of progress indicators",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.ProgressIndicatorsScreen.route)
                }
            )

            ItemComponents(
                title = "Snackbars and Dialogs",
                description = "How to open dialogs and show snackbars",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.SnackbarAndDialogScreen.route)
                }
            )

            ItemComponents(
                title = "Basic Animations",
                description = "How to work with animations basics",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.AnimatedBoxScreen.route)
                }
            )

            ItemComponents(
                title = "UI Controls",
                description = "How to work with switch, radio buttons, etc",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.UiControlsScreen.route)
                }
            )

            ItemComponents(
                title = "LazyColumn and Pull to Refresh",
                description = "How pull to refresh works with LazyColumn",
                icon = {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                onNavigate = {
                    onNavigate(Routes.InfiniteListAndPullToRefreshScreen.route)
                }
            )
        }
    }
}

