//package com.example.tugasil.screen
//
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.res.vectorResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.jetpackcompose.R
//import com.example.tugasil.R
//
//@Composable
//fun Profile(name: String, age: Int, profilePicture: ImageVector) {
//    var isSelected by remember { mutableStateOf(false) }
//    val backgroundColor by animateColorAsState(
//        targetValue = if (isSelected) Color.LightGray else Color.Transparent,
//        animationSpec = tween(durationMillis = 300)
//    )
//
//    Surface(
//        modifier = Modifier
//            .padding(16.dp)
//            .clip(CircleShape)
//            .clickable { isSelected = !isSelected }
//            .background(color = backgroundColor)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.padding(16.dp)
//        ) {
//            ProfilePicture(profilePicture = profilePicture)
//            Spacer(modifier = Modifier.height(16.dp))
//            ProfileInfo(name = name, age = age)
//        }
//    }
//}
//
//@Composable
//fun ProfilePicture(profilePicture: ImageVector) {
//    androidx.compose.material.Icon(
//        imageVector = profilePicture,
//        contentDescription = null,
//        modifier = Modifier
//            .size(120.dp)
//            .clip(CircleShape),
//        tint = Color.Blue
//    )
//}
//
//@Composable
//fun ProfileInfo(name: String, age: Int) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
////        androidx.compose.material.Text(text = name, style = MaterialTheme.typography.h5)
////        androidx.compose.material.Text(text = "Age: $age", fontSize = 20.sp)
//    }
//}
//
//@Preview
//@Composable
//fun PreviewProfile() {
//    Profile(name = "John Doe", age = 30, profilePicture = ImageVector.vectorResource(id = R.drawable.profile))
//}
