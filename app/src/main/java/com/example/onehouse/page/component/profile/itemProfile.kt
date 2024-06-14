package com.example.onehouse.page.component.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onehouse.R
import com.example.onehouse.page.component.profile.data.data
import com.example.onehouse.page.component.profile.model.icProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemProfile(
    modifier: Modifier = Modifier,
    navController: NavController,
    imageIc: icProfile,
    idProfile: List<icProfile> = data.profile,
) {
    var clicked by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (clicked) 1.9f else 2.0f)
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .padding(horizontal = 10.dp, vertical = 55.dp)
                .shadow(10.dp, RoundedCornerShape(20.dp), clip = false, ambientColor = Color.Black)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xff4F46E5)),

            ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(20.dp)
            ) {
                Image(
                    painter = painterResource(id = imageIc.image),
                    modifier = Modifier.size(width = 95.dp, height = 100.dp),
                    contentDescription = "Icon Profile"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    TextField(
                        value = imageIc.name,
                        onValueChange = {},
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        ),
                        readOnly = true,
                        singleLine = true,
                        modifier = Modifier
                            .size(width = 180.dp, height = 70.dp)
                            .padding(8.dp)
                    )

                    TextField(
                        value = imageIc.email,
                        onValueChange = {},
                        textStyle = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                        ),
                        readOnly = true,
                        singleLine = true,
                        modifier = Modifier
                            .size(width = 180.dp, height = 70.dp)
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Box(
                    modifier = Modifier
                        .size(width = 50.dp, height = 33.dp)
                        .clickable { navController.navigate("editProfile/${imageIc.id}") }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Icon Back",
                        tint = Color.White,
                        modifier = Modifier.size(50.dp, 33.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun Settings() {
    var expandedItem by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .shadow(2.dp, RoundedCornerShape(20.dp), clip = false, ambientColor = Color.Black)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(0xffF3F4F6))
            .clickable {
                expandedItem = if (expandedItem == "about") null else "about"
            },
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_about),
                        modifier = Modifier
                            .size(width = 22.dp, height = 25.dp),
                        contentDescription = "Icon About"
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "About",
                        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                    )
                }
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            }

        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 40.dp)
        ) {
            Column {
                AnimatedVisibility(
                    visible = expandedItem == "about",
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "One House adalah sebuah perusahaan real estate yang mengkhususkan diri dalam penjualan dan penyewaan properti, termasuk rumah, vila, apartemen, dan tanah. Kami hadir untuk memenuhi kebutuhan Anda akan hunian yang nyaman, strategis, dan sesuai dengan gaya hidup modern.",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .padding(
                start = 10.dp, end = 10.dp
            )
            .shadow(2.dp, RoundedCornerShape(20.dp), clip = false, ambientColor = Color.Black)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(0xffF3F4F6))
            .clickable {
                expandedItem = if (expandedItem == "setting") null else "setting"
            },
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_set),
                        modifier = Modifier
                            .size(width = 22.dp, height = 25.dp),
                        contentDescription = "Icon Setting"
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Setting",
                        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 40.dp)
        ) {
            Column {
                AnimatedVisibility(
                    visible = expandedItem == "setting",
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "One House adalah sebuah perusahaan real estate yang mengkhususkan diri dalam penjualan dan penyewaan properti, termasuk rumah, vila, apartemen, dan tanah. Kami hadir untuk memenuhi kebutuhan Anda akan hunian yang nyaman, strategis, dan sesuai dengan gaya hidup modern.",
                            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 10.dp, end = 10.dp)
            .shadow(2.dp, RoundedCornerShape(20.dp), clip = false, ambientColor = Color.Black)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color(0xffF3F4F6))
            .clickable {
                expandedItem = if (expandedItem == "logout") null else "logout"
            },

        ) {
        Row(
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_log_out),
                        modifier = Modifier
                            .size(width = 22.dp, height = 25.dp),
                        contentDescription = "Icon log out"
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Log Out",
                        style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 40.dp, horizontal = 20.dp), contentAlignment = Alignment.Center
        ) {
            Column(
            ) {
                AnimatedVisibility(
                    visible = expandedItem == "logout",
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 20.dp),
                    ) {
                        Text(text = "Apakah Anda yakin Ingin Keluar?")
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                        ) {
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(
                                        Color(0xff4F46E5),
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff4F46E5),
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "No")

                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(
                                        Color.Red,
                                        shape = RoundedCornerShape(10.dp)
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(text = "Yes")
                            }
                        }
                    }
                }
            }
        }
    }
}

