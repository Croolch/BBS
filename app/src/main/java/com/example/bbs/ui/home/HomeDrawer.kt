package com.example.bbs.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bbs.R

@Composable
fun HomeDrawer( onClickBackLogin: () -> Unit = {} ) {
    Column(Modifier.fillMaxHeight().padding(16.dp)) {
        // Header
        val image = painterResource(R.drawable.test)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(82.dp)
                    .clip(CircleShape)
            )
            Column(Modifier.padding(start = 16.dp)) {
                Text("user.name", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.height(36.dp))
                Text("user.discribe", modifier = Modifier.height(20.dp))
            }

        }

        Divider(Modifier.padding(vertical = 8.dp))

        // Drawer items

        data class cardinfo(val icon: ImageVector, val text: String)

        val draweritems = listOf(
            cardinfo(Icons.Filled.AccountBox, "我的资料"),
            cardinfo(Icons.Filled.Article, "我的帖子"),
            cardinfo(Icons.Filled.Comment, "我的评论"),
            cardinfo(Icons.Filled.AllInbox, "我的收藏"),
            cardinfo(Icons.Filled.Settings, "设置"),
        )

        Column() {
            for (item in draweritems) {
                DrawerContentCards(item.icon, item.text)
            }
        }

        // bottom
        Spacer(modifier = Modifier.weight(1f))
        DrawerContentCards(Icons.Filled.Logout, "退出登录", onClickBackLogin)
    }

}

@Composable
fun DrawerContentCards(icon: ImageVector, text: String, onClickFunc: () -> Unit = {}) {
    Column(modifier = Modifier
        .padding(vertical = 8.dp)
        .clickable(onClick = onClickFunc)  /*TODO mutablestate??*/
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null)
            Text(text = text, Modifier.padding(start = 20.dp))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DrawerPreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        HomeDrawer()
    }
}