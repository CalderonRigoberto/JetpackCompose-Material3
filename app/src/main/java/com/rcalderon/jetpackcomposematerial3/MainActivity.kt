package com.rcalderon.jetpackcomposematerial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.rcalderon.jetpackcomposematerial3.core.navigation.AppNavigation
import com.rcalderon.jetpackcomposematerial3.presentation.theme.JetpackComposeMaterial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JetpackComposeMaterial3Theme {
                AppNavigation()
            }
        }
    }
}