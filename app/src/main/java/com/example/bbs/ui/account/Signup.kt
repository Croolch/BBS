package com.example.bbs.ui.account

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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
import com.example.bbs.model.state.ModelState
import com.example.bbs.model.state.SignupState
import com.example.bbs.viewmodel.SignupViewModel

@Composable
fun Signup(
    onClickBack: () -> Unit = {},
    vm: SignupViewModel = viewModel()
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "注册") },
            navigationIcon = {
                IconButton(
                    onClick = onClickBack
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            },
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

            var username by rememberSaveable { mutableStateOf("") }
            var accounttext by rememberSaveable { mutableStateOf("") }
            var passwordtext by rememberSaveable { mutableStateOf("") }
            var repasswordtext by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "用户名") },
                modifier = Modifier.padding(vertical = 4.dp)
            )
            OutlinedTextField(
                value = accounttext,
                onValueChange = { accounttext = it },
                label = { Text(text = "账号") },
                modifier = Modifier.padding(vertical = 4.dp)
            )
            OutlinedTextField(
                value = passwordtext,
                onValueChange = { passwordtext = it },
                label = { Text(text = "密码") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(vertical = 4.dp)
            )

            var iserrorstate = false
            OutlinedTextField(
                value = repasswordtext,
                onValueChange = {
                    repasswordtext = it
                    if (repasswordtext != passwordtext)
                        iserrorstate = true
                },
                label = { Text(text = "重复密码") },
                visualTransformation = PasswordVisualTransformation(),
                isError = iserrorstate,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.weight(0.1f))

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    onClick = {
//                        vm.getSignupData(accounttext, passwordtext, username)
//                        when (val result = vm.signupData.value){
//                            is ModelState.Success -> {
//                                if (result.data.message == "SUCCESS_SIGNUP")
//                                    onClickBack()
//                                else
//                                    Log.d(ContentValues.TAG, "Signup: ViewModel---------------------failed")
//                            }
//                            is ModelState.Failure -> {
//                                Log.d("Login: ViewModel---------------------No Value", result.error.toString())
//                            }
//                            else -> {
//                                Log.d(ContentValues.TAG, "Signup: ViewModel---------------------No Value")
//                            }
//                        }
                        onClickBack()
                    } /*TODO 存值然后返回*/,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
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
fun SignupPreview() {
    MaterialTheme {
        // A surface container using the 'background' color from the theme
        Signup()
    }
}
