package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SnackBarsAndDialogsScreen(
    onNavigateBack: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val openDialog = remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        topBar = {
            TopAppBar(
                title = {
                    Text("SnackBars And Dialogs Screen")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar(
                            "This is a snackbar",
                            "Accept",
                            duration = SnackbarDuration.Long
                        )
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.Send,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text("Show Snackbar")
            }
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    openDialog.value = !openDialog.value
                }
            ) {
                Text("Show Dialog")
            }
        }

        if (openDialog.value) {
            AlertDialog(
                title = { Text("Alert Dialog") },
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.Send,
                        contentDescription = null
                    )
                },
                text = { Text("This is a dialog of Material3 in Jetpack Compose with buttons and icons") },
                onDismissRequest = { openDialog.value = false },
                confirmButton = {
                    Button(
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    "Dialog accepted",
                                    "Ok",
                                    duration = SnackbarDuration.Short
                                )
                            }
                            openDialog.value = false
                        }
                    ) {
                        Text("Accept")
                    }
                },
                dismissButton = {
                    OutlinedButton(
                        onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar(
                                    "Dialog canceled",
                                    "Cancel",
                                    duration = SnackbarDuration.Short
                                )
                            }
                            openDialog.value = false
                        }
                    ) {
                        Text("Cancel")
                    }
                }
            )
        }

    }
}