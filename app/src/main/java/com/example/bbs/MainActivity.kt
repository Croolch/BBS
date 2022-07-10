package com.example.bbs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bbs.ui.account.Login
import com.example.bbs.ui.account.Signup
import com.example.bbs.ui.article.ArticlePage
import com.example.bbs.ui.article.PostArticlePage
import com.example.bbs.ui.home.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                val navController = rememberNavController()
                val backstackEntry = navController.currentBackStackEntryAsState()
                NavHost(
                    navController = navController,
                    startDestination = "LoginScreen"
                ) {
                    composable("LoginScreen") {
                        Login(
                            onClickGoHome = { navController.navigate("HomeViewScreen") },
                            onClickGoSignup = { navController.navigate("SignupScreen") }
                        )
                    }
                    composable("SignupScreen") {
                        Signup(onClickBack = { navController.popBackStack() })
                    }
                    composable("ArticleScreen/{id}", arguments = listOf(
                        navArgument("id"){
                            type = NavType.IntType
                        }
                    )) {
                        val idstring = it.arguments?.getInt("id")?: 0
                        ArticlePage(onClickBack = { navController.popBackStack() }, idstring)
                    }
                    composable("HomeViewScreen") {
                        HomeView(
                            navController = navController,
                            onClickGoPostArticle = { navController.navigate("PostArticleScreen") },
                            onClickDrawerBack = {
                                navController.navigate("LoginScreen") {
                                    popUpTo("LoginScreen"){
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable("PostArticleScreen") {
                        PostArticlePage(onClickBack = { navController.popBackStack() })
                    }

                }
            }
        }
    }
}
