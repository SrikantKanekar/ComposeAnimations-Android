package com.example.animationplayground.ui.infiniteTransition

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold

@ExperimentalMaterialApi
@Composable
fun InfiniteTransitionScreen(
    viewModel: InfiniteTransitionViewModel,
    navController: NavHostController
) {
    MyBottomSheetScaffold(
        title = "Infinite Transition",
        navController = navController,
        animate = {  },
        content = {

            val infiniteTransition = rememberInfiniteTransition()

            val color by infiniteTransition.animateColor(
                initialValue = Color.Green,
                targetValue = Color.Red,
                animationSpec = infiniteRepeatable(
                    animation = tween()
                )
            )

            val alpha by infiniteTransition.animateFloat(
                initialValue = 0F,
                targetValue = 1F,
                animationSpec = infiniteRepeatable(
                    animation = tween()
                )
            )

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