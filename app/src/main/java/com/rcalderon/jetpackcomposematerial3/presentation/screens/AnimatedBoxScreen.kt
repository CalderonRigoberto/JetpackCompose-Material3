package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rcalderon.jetpackcomposematerial3.core.utils.RandomColor.randomColor
import kotlin.random.Random


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AnimatedBoxScreen(
    onNavigateBack: () -> Unit
) {
    var randomSize by remember { mutableStateOf((Random.nextInt(200) + 100).dp) }
    var randomColor by remember { mutableStateOf(Color.Red) }
    var expanded by remember { mutableStateOf(true) }
    val boxSize: Dp by animateDpAsState(
        targetValue = if (expanded) randomSize else 100.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Animated Box Screen")
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
                    randomColor = randomColor()
                    randomSize = (Random.nextInt(200) + 100).dp
                    expanded = !expanded
                }
            ) {
                Text(text = if (expanded) "Shrink & Change the color" else "Expand & Change the color")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(boxSize),
                colors = CardDefaults.cardColors(
                    containerColor = randomColor
                )
            ) {}
        }
    }
}

