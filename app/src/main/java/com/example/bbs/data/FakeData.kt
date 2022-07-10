package com.example.bbs.data

import com.example.bbs.model.Article
import com.example.bbs.model.ArticleData
import com.example.bbs.model.Author
import com.example.bbs.model.Post

val post1 = Post(
    id = 1,
    title = "A Little Thing about Android Module Paths",
    author = "author1",
    comments = 100,
    postDate = "2020",
    tags = listOf("java", "Idea"),
    views = 10000,
    votes = 20
)

val post2 = Post(
    id = 1,
    title = "Dagger in Kotlin: Gotchas and Optimizations",
    author = "author2",
    comments = 100,
    postDate = "2020",
    tags = listOf("java", "Idea"),
    views = 10000,
    votes = 20
)

val post3 = Post(
    id = 1,
    title = "From Java Programming Language to Kotlin — the idiomatic way",
    author = "author3",
    comments = 100,
    postDate = "2020",
    tags = listOf("java", "Idea"),
    views = 10000,
    votes = 20
)
val postlist = listOf<Post>(post1, post2, post3, post3, post3, post3, post3, post3, post3, post3, post3, post3, post3)

var article = ArticleData(article = Article(
    title = "What's the simplest way in Python to detect the time placement of individual audio files over a longer sequence?",
    postDate = "2022-01-25",
    views = 14,
    votes = 1,
    comments = 15,
    tags =  listOf("c++", "python", "audio"),
    content = "1.你用一次性纸杯做实验的样子真是太美了2.滴管那么插试剂瓶里请问该怎么取出来3.我寻思这个盖子这么个放法师兄不会骂人吗4.这披散这头发还是有点碍事吧5.老师判了死刑的实验被本科生做出来，要么天赋异禀要么老师也是个水货 从实验细节来看我觉得我觉得天赋异禀是不是可能性不太大这个照片的尴尬程度直逼这则新闻啊"
),
    id = 1,
    author = Author(authorId = 1, authorName = "Swift142", avatar = "user/pic/123456.png",discribe = "haha")
)