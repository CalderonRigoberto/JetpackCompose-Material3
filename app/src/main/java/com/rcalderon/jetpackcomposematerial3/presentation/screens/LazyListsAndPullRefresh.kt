package com.rcalderon.jetpackcomposematerial3.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyListsAndPullRefreshScreen(
    onNavigateBack: () -> Unit
) {
    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    var itemCount by remember { mutableStateOf((1..10).toList()) }
    val state = rememberPullToRefreshState()

    fun refresh() =
        refreshScope.launch {
            refreshing = true
            delay(1500)
            itemCount += ((itemCount.last() - 1..itemCount.last() + 10).toMutableList())
            refreshing = false
        }



    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Lazy Lists And Pull Refresh Screen")
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
        PullToRefreshBox(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            isRefreshing = refreshing,
            state = state,
            onRefresh = {
                refresh()
            }
        ) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {

                items(itemCount.size) { index ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Text(text = "Item ${itemCount[index]}")
                        }
                    }
                }

            }
        }
    }

}