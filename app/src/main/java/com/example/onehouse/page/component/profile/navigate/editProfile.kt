package com.example.onehouse.page.component.profile.navigate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.onehouse.page.component.profile.data.data
import com.example.onehouse.page.component.profile.model.icProfile

@Composable
fun EditProfile(
    modifier: Modifier = Modifier,
    navController: NavController,
    profilId: Int?,
) {
    Column(
        modifier = Modifier.padding(vertical = 50.dp)
    ) {
        /// Top Bar ///
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(0xff818CF8))

        ) {
            Row(
                modifier = Modifier.padding(vertical = 10.dp)
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Back",
                        modifier = Modifier.size(width = 40.dp, height = 30.dp),
                        tint = Color.White
                    )
                }
                Box(
                    modifier = Modifier.padding(vertical = 13.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Bio-data", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
        val profile = data.profile.firstOrNull { it.id == profilId }

        profile?.let {
            var name by remember { mutableStateOf(it.name) }
            var email by remember { mutableStateOf(it.email) }
            ItemEdit(
                profile = it,
                name = name,
                onNameChange = { name = it },
                email = email,
                onEmailChange = { email = it },
                onSaveChanges = {

                    it.name = name
                    it.email = email
                    navController.popBackStack()
                }
            )
        } ?: run {
            Text("Profile not found")
        }
    }
}

@Composable
fun ItemEdit(
    profile: icProfile,
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    onSaveChanges: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(

        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 50.dp)

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(profile.image)
                    .build(),
                modifier = Modifier
                    .size(height = 150.dp, width = 150.dp)
                    .align(Alignment.CenterHorizontally),
                contentDescription = "Profile Image",

                )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = name,
                onValueChange = onNameChange,
                textStyle = TextStyle(
                    fontSize = 23.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = email,
                onValueChange = onEmailChange,
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = onSaveChanges,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Update")
            }
        }
    }
}
