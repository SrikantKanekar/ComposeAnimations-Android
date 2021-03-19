package com.example.animationplayground.ui.animationvisibility.fade

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun FadeScreen(
    navController: NavHostController,
    viewModel: FadeViewModel
) {

    MyBottomSheetScaffold(
        title = "FadeScreen",
        navController = navController,
        animate = { viewModel.animate() },
        content = {
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.Center),
                visible = viewModel.animationState,
                enter = fadeIn(
                    initialAlpha = viewModel.initialAlpha,
                    animationSpec = tween(
                        durationMillis = viewModel.durationMillis
                    )
                ),
                exit = fadeOut(
                    targetAlpha = viewModel.targetAlpha,
                    animationSpec = tween(
                        durationMillis = viewModel.durationMillis
                    )
                )
            ) {
                Text(text = "Text", fontSize = 60.sp)
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

                Text(text = "Initial alpha")
                Slider(
                    value = viewModel.initialAlpha,
                    onValueChange = { viewModel.initialAlpha = it })

                Text(text = "Target alpha")
                Slider(
                    value = viewModel.targetAlpha,
                    onValueChange = { viewModel.targetAlpha = it })
            }
        }
    )
}