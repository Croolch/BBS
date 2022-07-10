package com.example.bbs.ui.account

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bbs.R
import com.example.bbs.model.state.LoginState
import com.example.bbs.viewmodel.LoginViewModel

@Composable
fun Login(
    onClickGoHome: () -> Unit = {},
    onClickGoSignup: () -> Unit = {},
    vm: LoginViewModel = viewModel()
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "BBS  登录") },
        )
    }) {  innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(0.5f))
            Surface(color = Color.Green,modifier = Modifier
                .padding(16.dp)
                .clip(MaterialTheme.shapes.large)
                .background(Color.Green)) {
                Image(
                    painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "AppIcon",
                )
            }


            var accounttext by rememberSaveable { mutableStateOf("") }
            var passwordtext by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = accounttext,
                onValueChange = { accounttext = it },
                label = { Text(text = "账号") },
                modifier = Modifier.padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = passwordtext,
                onValueChange = { passwordtext = it },
                label = { Text(text = "密码") },
                visualTransformation = PasswordVisualTransformation(),
            )

            Spacer(modifier = Modifier.weight(0.1f))

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    onClick = {
//                        vm.getLoginData(accounttext, passwordtext)
//                        when (val result = vm.loginData.value) {
//                            is LoginState.Success -> {
//                                if (result.login.message == "SUCCESS_LOGIN")
//                                    onClickGoHome()
//                                else
//                                    Log.d(TAG, "Login: ViewModel---------------------failed")
//                            }
//                            is LoginState.Failure -> {
//                                Log.d("Login: ViewModel---------------------No Value", result.error.toString())
//                            }
//                            else -> {}
//                        }
                        onClickGoHome()
                    } /*todo check account*/ , modifier = Modifier.padding(end = 8.dp)) {
                    Text(
                        text = "登录",
                        style = MaterialTheme.typography.button
                    )
                }

                Button(onClick = onClickGoSignup , modifier = Modifier.padding(end = 8.dp)) {
                    Text(
                        text = "注册",
                        style = MaterialTheme.typography.button
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        Surface {
//            Login()
        }

    }
}