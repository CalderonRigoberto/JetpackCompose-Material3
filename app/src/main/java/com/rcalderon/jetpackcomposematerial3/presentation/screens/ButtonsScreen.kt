package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ButtonScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Button Screen")
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
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
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ElevatedButton(
                    onClick = {}
                ) {
                    Text("Elevated Button")
                }

                OutlinedButton(
                    onClick = {}
                ) {
                    Text("Outlined Button")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FilledTonalButton(
                    onClick = {}
                ) {
                    Text("Tonal Button")
                }
                TextButton(
                    onClick = {}
                ) {
                    Text("Text Button")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            var selectedIndex by remember { mutableIntStateOf(0) }
            val options = listOf("Day", "Month", "Week")

            SingleChoiceSegmentedButtonRow {
                options.forEachIndexed { index, label ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size
                        ),
                        onClick = { selectedIndex = index },
                        selected = index == selectedIndex,
                        label = { Text(label) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Icon Button")
                }

                FilledIconButton(onClick = {}) {
                    Icon(imageVector = Icons.Rounded.Create, contentDescription = null)
                }

                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "Floating Action Button")
                }

                ExtendedFloatingActionButton(onClick = {}) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Rounded.Create, contentDescription = "Extended Floating Action Button")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text("Extended FAB")
                    }
                }
            }
        }
    }
}