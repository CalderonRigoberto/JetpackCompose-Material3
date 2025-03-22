package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun UiControlsScreen(
    onNavigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("UI Controls Screen")
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
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp),
        ) {
            val selected = remember { mutableStateOf(true) }
            Row (
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                        selected.value = !selected.value
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(if (selected.value) "Radio Button { Selected }" else "Radio Button { Not Selected }")
                Spacer(modifier = Modifier.width(5.dp))
                RadioButton(
                    selected = selected.value,
                    onClick = { selected.value = !selected.value },
                )
            }

            val (checked, onChecked) = remember { mutableStateOf(true) }
            Row (
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                        onChecked.invoke(!checked)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(if (checked) "Checkbox { Checked }" else "Checkbox { Not Checked }")
                Spacer(modifier = Modifier.width(5.dp))
                Checkbox(
                    checked = checked,
                    onCheckedChange = onChecked,
                )
            }

            var expanded by remember { mutableStateOf(true) }
            Row (
                modifier = Modifier.fillMaxWidth()
                    .clickable {
                        onChecked.invoke(!checked)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .animateContentSize(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = LinearOutSlowInEasing
                            )
                        )
                        .clickable{
                            expanded = !expanded
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text("Configuration values", style = MaterialTheme.typography.labelLarge)
                            IconButton(
                                onClick = { expanded = !expanded }
                            ) {
                                Icon(imageVector = if(expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp, contentDescription = null)
                            }
                        }
                        if(expanded) {
                            (1..4).forEach {
                                Row(
                                    modifier = Modifier.fillMaxWidth()
                                        .clickable {
                                            onChecked.invoke(!checked)
                                        },
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                ) {
                                    Text(if (checked) "Checkbox { Checked }" else "Checkbox { Not Checked }")
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Checkbox(
                                        checked = checked,
                                        onCheckedChange = onChecked,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}