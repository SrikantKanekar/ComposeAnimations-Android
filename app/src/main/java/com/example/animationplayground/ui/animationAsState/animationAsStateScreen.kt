package com.example.animationplayground.ui.animationAsState

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold
import com.example.animationplayground.components.TextSlider
import com.example.animationplayground.ui.animationAsState.AnimateAsStateViewModel.AnimateAsStateStates.END
import com.example.animationplayground.ui.animationAsState.AnimateAsStateViewModel.AnimateAsStateStates.START

@ExperimentalMaterialApi
@Composable
fun AnimateAsStateScreen(
    viewModel: AnimateAsStateViewModel,
    navController: NavHostController
) {
    MyBottomSheetScaffold(
        title = "AnimateAsState",
        navController = navController,
        animate = { viewModel.animate() },
        content = {

            Crossfade(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 40.dp)
                    .animateContentSize(),
                targetState = viewModel.animationState.name
            ) { state ->
                Text(
                    text = state,
                    style = MaterialTheme.typography.h4
                )
            }

            val alpha by animateFloatAsState(
                targetValue = when (viewModel.animationState) {
                    START -> viewModel.startValue
                    END -> viewModel.endValue
                }
            )

            Canvas(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(70.dp)
                    .alpha(alpha)
            ) {
                drawRect(color = Color.Black)
            }
        },
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp, vertical = 40.dp)
                    .verticalScroll(rememberScrollState())
                    .animateContentSize(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextSlider(
                    text = "Start Value",
                    value = viewModel.startValue,
                    onValueChange = { viewModel.startValue = it },
                    valueRange = 0F..1F
                )
                TextSlider(
                    text = "End Value",
                    value = viewModel.endValue,
                    onValueChange = { viewModel.endValue = it },
                    valueRange = 0F..1F
                )
            }
        }
    )
}