package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CardsScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Cards Screen")
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxWidth()
        ) {
            ElevatedCard(
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
            ) {
                Column(
                    modifier = Modifier.padding(5.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Elevated Card", style = MaterialTheme.typography.bodyLarge)
                        Icon(imageVector = Icons.AutoMirrored.Rounded.List, contentDescription = null)
                    }

                }
            }

            Card (
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
            ) {
                Column(
                    modifier = Modifier.padding(5.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Filled Card", style = MaterialTheme.typography.bodyLarge)
                        Icon(imageVector = Icons.AutoMirrored.Rounded.List, contentDescription = null)
                    }

                }
            }

            OutlinedCard (
                modifier = Modifier.padding(10.dp)
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Column(
                    modifier = Modifier.padding(5.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Outlined Card", style = MaterialTheme.typography.bodyLarge)
                        Icon(imageVector = Icons.AutoMirrored.Rounded.List, contentDescription = null)
                    }

                }
            }
        }
    }
}