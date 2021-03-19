package com.example.animationplayground.ui.animationvisibility.expand

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Slider
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ExpandScreen(
    viewModel: ExpandViewModel,
    navController: NavHostController
) {
    MyBottomSheetScaffold(
        title = "Expand  Animation",
        navController = navController,
        animate = { viewModel.animate() },
        content = {
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.Center),
                visible = viewModel.animationState,
                enter = expandIn(
                    animationSpec = tween(
                        durationMillis = viewModel.durationMillis
                    ),
                    clip = viewModel.clip
                ),
                exit = shrinkOut(
                    animationSpec = tween(
                        durationMillis = viewModel.durationMillis
                    ),
                    clip = viewModel.clip
                )
            ) {
                Text(
                    text = "Text",
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

                Text(text = "Clip")
                Switch(
                    checked = viewModel.clip,
                    onCheckedChange = { viewModel.clip = it }
                )
            }
        }
    )
}