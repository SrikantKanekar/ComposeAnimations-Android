package com.example.animationplayground.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate("FadeScreen") }) {
                Text(text = "FadeScreen")
            }

            Button(onClick = { navController.navigate("ExpandScreen") }) {
                Text(text = "ExpandScreen")
            }
            Button(onClick = { navController.navigate("CrossFadeScreen") }) {
                Text(text = "CrossFadeScreen")
            }
        }
    }
}