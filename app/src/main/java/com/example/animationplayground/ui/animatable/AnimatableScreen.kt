package com.example.animationplayground.ui.animatable

import androidx.compose.animation.Animatable
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold
import com.example.animationplayground.ui.animatable.AnimatableViewModel.AnimatableStates.*

@ExperimentalMaterialApi
@Composable
fun AnimatableScreen(
    viewModel: AnimatableViewModel,
    navController: NavHostController
) {
    MyBottomSheetScaffold(
        title = "Animatable",
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

            val color = remember { Animatable(Color.Gray) }
            LaunchedEffect(viewModel.animationState) {
                color.animateTo(
                    when (viewModel.animationState) {
                        START -> Color.Green
                        END -> Color.Red
                    }
                )
            }

            Canvas(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(70.dp)
            ) {
                drawRect(color = color.value)
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

            }
        }
    )
}