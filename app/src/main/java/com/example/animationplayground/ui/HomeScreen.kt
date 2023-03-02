package com.example.animationplayground.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.HomeButton

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Home") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            HomeButton(text = "FadeScreen") {
                navController.navigate("FadeScreen")
            }
            HomeButton(text = "ExpandScreen") {
                navController.navigate("ExpandScreen")
            }
            HomeButton(text = "CrossFadeScreen") {
                navController.navigate("CrossFadeScreen")
            }
            HomeButton(text = "AnimateAsStateScreen") {
                navController.navigate("AnimateAsStateScreen")
            }
            HomeButton(text = "AnimatableScreen") {
                navController.navigate("AnimatableScreen")
            }
            HomeButton(text = "UpdateTransitionScreen") {
                navController.navigate("UpdateTransitionScreen")
            }
            HomeButton(text = "InfiniteTransitionScreen") {
                navController.navigate("InfiniteTransitionScreen")
            }
            HomeButton(text = "GestureScreen") {
                navController.navigate("GestureScreen")
            }
            HomeButton(text = "SwipeToDismissScreen") {
                navController.navigate("SwipeToDismissScreen")
            }
            HomeButton(text = "TransformableScreen") {
                navController.navigate("TransformableScreen")
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}