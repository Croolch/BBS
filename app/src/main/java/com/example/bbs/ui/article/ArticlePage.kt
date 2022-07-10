package com.example.bbs.ui.article

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.bbs.data.article
import com.example.bbs.ui.post.TagText
import com.example.bbs.viewmodel.ArticleViewModel

@Composable
fun ArticlePage(
    onClickBack: () -> Unit = {},
    articleid: Int,
    vm: ArticleViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {  },
                navigationIcon = {
                    IconButton(
                        onClick = onClickBack
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { /* TODO: Open search navigation? */ }
                    ) {
                        Icon(Icons.Filled.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                // The actions should be at the end of the BottomAppBar. They use the default medium
                // content alpha provided by BottomAppBar
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth(0.6f)
                ) {
                    Text(text = "评论")
                }
                Spacer(Modifier.weight(1f, true))
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Bookmark, contentDescription = "Localized description")
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.ThumbUp, contentDescription = "Localized description")
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Comment, contentDescription = "Localized description")
                }
            }
        }
    ) { innerPadding ->
        // Screen content
//        var article: ArticleData
//        vm.getArticleData(articleid)
//        when (val result = vm.data.value) {
//            is ModelState.Success -> {
//                article = result.data
        var article = article
                Column(
                    Modifier
                        .padding(innerPadding)
                        .padding(16.dp)) {
                    // title
                    Row() {

                        Text(text = article.article.title, style = MaterialTheme.typography.h4)
                    }
                    // head image
                    val image = painterResource(com.example.bbs.R.drawable.test)
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
//                        AsyncImage(
//                            model = image,
//                            contentDescription = null,
//                            modifier = Modifier
//                                .size(54.dp)
//                                .clip(CircleShape)
//                        )
                        Image(
                            painter = image,
                            contentDescription = null,
                            modifier = Modifier
                                .size(54.dp)
                                .clip(CircleShape)
                        )
                        Column(Modifier.padding(start = 12.dp)) {
                            Text(article.author.authorName, style = MaterialTheme.typography.subtitle2)
                            Text(article.article.postDate, style = MaterialTheme.typography.caption)
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(end = 8.dp) ) {
                            Text(text = "关注", style = MaterialTheme.typography.button)
                        }
                    }
                    // tag row
                    Row(Modifier.padding(vertical = 8.dp)) {
                        article.article.tags.forEachIndexed { index, s -> TagText(text = s) }
                    }
                    // body
                    Text(article.article.content, style = MaterialTheme.typography.body1)
                }
            }
        }

//    }

//}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        ArticlePage(articleid = 0)
    }
}