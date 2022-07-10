package com.example.bbs.ui.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostArticlePage(
    onClickBack: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "文章投稿",
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onClickBack
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(
                        onClick = onClickBack /* TODO: 存值然后返回 */
                    ) {
                        Text(text = "发布")
                    }
                }
            )
        }
    ) { innerPadding->
        Column(
            Modifier.padding(innerPadding).fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var titletext by rememberSaveable { mutableStateOf("") }
            var tagtext by rememberSaveable { mutableStateOf("") }
            var bodytext by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                value = titletext,
                onValueChange = { titletext = it },
                label = { Text("标题") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = tagtext,
                onValueChange = { tagtext = it },
                label = { Text("标签") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = bodytext,
                onValueChange = { bodytext = it },
                label = { Text("内容") },
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f).padding(vertical = 8.dp)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PostArticlePreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        PostArticlePage()
    }
}