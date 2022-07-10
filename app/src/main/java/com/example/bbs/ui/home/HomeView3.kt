package com.example.bbs.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3() {
    MaterialTheme {
        val colors = listOf(
            Color(0xFFffd7d7.toInt()),
            Color(0xFFffe9d6.toInt()),
            Color(0xFFfffbd0.toInt()),
            Color(0xFFe3ffd9.toInt()),
            Color(0xFFd0fff8.toInt())
        )

        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
// icons to mimic drawer destinations
        val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
        val selectedItem = remember { mutableStateOf(items[0]) }

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerTonalElevation = 1.dp,
            drawerContent = {
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            },
            content = {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                    Spacer(Modifier.height(20.dp))
                    Button(onClick = { scope.launch { drawerState.open() } }) {
                        Text("Click to open")
                    }
                }
            },

        )

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Centered TopAppBar") },
                    navigationIcon = {
                        IconButton(onClick = {  scope.launch { drawerState.open() }  }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            },

            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = { /* fab click handler */ }
                ) {
                    Text("Inc")
                }
            },
            content = { innerPadding ->
                LazyColumn(contentPadding = innerPadding) {
                    items(count = 100) {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .background(colors[it % colors.size])
                        )
                    }
                }
            }
        )



    }
}

@Preview(showBackground = true)
@Composable
fun Home3Preview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        HomeView3()
    }
}
