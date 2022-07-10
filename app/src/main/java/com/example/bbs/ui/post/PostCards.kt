package com.example.bbs.ui.post

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbs.data.post1
import com.example.bbs.data.postlist
import com.example.bbs.model.Post

@Composable
fun PostCardSample(post: Post) {
    Row(
        modifier = Modifier
            .clickable(onClick = { /*todo navigation*/ })
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                post.title,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.Bottom) {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = post.author,
                        style = MaterialTheme.typography.body2,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                TagText("tag1")
                TagText("tag2")
                Spacer(modifier = Modifier.weight(0.1f))
            }
        }
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = null // handled by click label of parent
        )
    }
}

@Composable
fun PostListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
fun TagText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.caption,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colors.secondary)
            .padding(horizontal = 2.dp)
    )
}

@Preview
@Composable
fun PostPreview() {
    PostCardSample(post1)
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PostListPreview() {
    MaterialTheme {
        LazyColumn() {
            for (post in postlist) {
                item {
                    Column() {
                        PostCardSample(post)
                        PostListDivider()
                    }
                }
            }
        }
    }
}
