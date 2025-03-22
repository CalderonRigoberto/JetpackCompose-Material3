package com.rcalderon.jetpackcomposematerial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.rcalderon.jetpackcomposematerial3.core.data.datastore.repositories.ThemeDataStore
import com.rcalderon.jetpackcomposematerial3.core.navigation.AppNavigation
import com.rcalderon.jetpackcomposematerial3.presentation.theme.JetpackComposeMaterial3Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var ThemeDataStore: ThemeDataStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ThemeDataStore = ThemeDataStore(this)
        setContent {
            val themeScope = rememberCoroutineScope()
            val isDarkTheme by ThemeDataStore.preferencesTheme.collectAsState(initial = false)
            JetpackComposeMaterial3Theme(
                darkTheme = isDarkTheme
            ) {
                AppNavigation(
                    isDarkTheme,
                    onChangeTheme = {
                        themeScope.launch {
                            ThemeDataStore.changeTheme(it)
                        }
                    }
                )
            }
        }
    }
}