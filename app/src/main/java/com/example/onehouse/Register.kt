package com.example.onehouse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.viewmodel.AuthViewModel

@Composable
fun Register(navController: NavController, authViewModel: AuthViewModel) {
    val registerResult by authViewModel.registerResult.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Masuk Sekarang", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.logo_onehouse),
            contentDescription = "Login Image",
            modifier = Modifier.size(250.dp))

        Text(text = "Halo selamat datang!!", fontSize = 15.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = "Mari mulai membuat akun Anda", fontSize = 15.sp, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = {
            Text(text = "Email/No. Hp")
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = {
            Text(text = "Kata Sandi")
        }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Belum punya akun?",
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                text = "Masuk",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("signIn")
                }
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            onClick = { authViewModel.register(email, password) }) {
            Text(text = "Daftar")
        }

//        when (registerResult) {
//            is Result.Success -> {
//                navController.navigate("homeNav")
//            }
//            is Result.Failure -> {
//                Text(text = (registerResult as Result.Failure).exception.message ?: "Registration failed", color = androidx.compose.ui.graphics.Color.Red)
//            }
//            else -> {}
//        }
    }
}