package com.example.bbs.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.bbs.data.postlist
import com.example.bbs.data.users.impl.jose
import com.example.bbs.ui.post.PostCardSample
import com.example.bbs.ui.post.PostListDivider
import com.example.bbs.viewmodel.PostListViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeView(
    navController: NavController,
    onClickGoPostArticle: () -> Unit = {},
    onClickDrawerBack: () -> Unit,
    vm: PostListViewModel = viewModel(),
) {
    MaterialTheme() {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        // user
        val user = jose

        var selectedListNumber = 0

        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                HomeDrawer(onClickDrawerBack)
            },
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "BBS",
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { /* TODO: Open search navigation? */ }
                        ) {
                            Icon(
                                Icons.Filled.Search, contentDescription = null
                            )
                        }
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(onClick = onClickGoPostArticle ) {
                    Icon(Icons.Filled.Add, contentDescription = "Localized description")
                }
            },
        ) { innerPadding ->
            Surface(Modifier.padding(innerPadding)) { }
            // Screen content
            Column() {
                var state by remember { mutableStateOf(0) }
                val titles = listOf("热门", "最新")
                TabRow(selectedTabIndex = state) {
                    titles.forEachIndexed { index, title ->
                        Tab(
                            text = { Text(title) },
                            selected = state == index,
                            onClick = { state = index }
                        )
                    }
                }

                // postcards
                var selectedIndex by remember{mutableStateOf(-1)}
//                vm.getData("top")
//                val posts = vm.listdata
                LazyColumn() {
                    postlist.forEachIndexed { index, post ->
                        item {
                            Column(
                                Modifier.selectable(
                                    selected = index == selectedIndex,
                                    onClick = { navController.navigate("ArticleScreen/${post.id}") }, /*todo navigate to article*/
                                )
                            ) {
                                PostCardSample(post)
                                PostListDivider()
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
//        HomeView(onClickGoPostArticle = {}, onClickDrawerBack = {})
    }
}
