package com.example.animationplayground.ui.crossfade

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold

@ExperimentalMaterialApi
@Composable
fun CrossFadeScreen(
    viewModel: CrossFadeViewModel,
    navController: NavHostController
) {
    MyBottomSheetScaffold(
        title = "CrossFade Animation",
        navController = navController,
        animate = { viewModel.animate() },
        content = {
            Crossfade(
                modifier = Modifier.align(Alignment.Center),
                targetState = viewModel.animationState,
                animationSpec = tween(
                    durationMillis = viewModel.durationMillis
                )
            ) {
                Text(
                    text = it,
                    fontSize = 60.sp
                )
            }
        },
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 40.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Duration in Millis")
                Slider(
                    value = viewModel.durationMillis.toFloat(),
                    onValueChange = { viewModel.durationMillis = it.toInt() },
                    valueRange = 0f..3000f
                )
            }
        }
    )
}