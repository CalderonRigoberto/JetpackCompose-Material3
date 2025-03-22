package com.rcalderon.jetpackcomposematerial3.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProgressIndicatorsScreen(onNavigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Progress Indicators Screen")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->

        BoxWithConstraints(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Linear Progress Indicator")
                Spacer(modifier = Modifier.height(10.dp))
                LinearProgressIndicator()

                Spacer(modifier = Modifier.height(50.dp))
                Text("Circle  Progress Indicator")
                Spacer(modifier = Modifier.height(10.dp))
                CircularProgressIndicator()
            }

            Text(
                modifier = Modifier.align(Alignment.BottomCenter).offset(y = (-16).dp),
                text = "Progress indicators communicate the status of an ongoing process",
                textAlign = TextAlign.Center
            )
        }
    }
}