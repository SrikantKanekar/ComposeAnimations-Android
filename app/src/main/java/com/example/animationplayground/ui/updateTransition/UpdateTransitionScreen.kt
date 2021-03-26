package com.example.animationplayground.ui.updateTransition

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold
import com.example.animationplayground.ui.updateTransition.UpdateTransitionViewModel.TransitionState.*

@ExperimentalMaterialApi
@Composable
fun UpdateTransitionScreen(
    viewModel: UpdateTransitionViewModel,
    navController: NavHostController
) {
    MyBottomSheetScaffold(
        title = "UpdateTransition",
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

            val transition = updateTransition(
                targetState = viewModel.animationState,
                label = null
            )

            val color by transition.animateColor { state ->
                when(state){
                    START -> Color.Black
                    MIDDLE -> Color.Green
                    END -> Color.Red
                }
            }

            val alpha by transition.animateFloat { state ->
                when(state){
                    START -> 1F
                    MIDDLE -> 0.6F
                    END -> 0.3F
                }
            }

            Canvas(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(70.dp)
            ) {
                drawRect(
                    color = color,
                    alpha = alpha
                )
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