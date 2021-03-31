package com.example.animationplayground.ui.gestures

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.MyBottomSheetScaffold
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun GesturesScreen(
    navController: NavHostController
) {

    MyBottomSheetScaffold(
        title = "Gesture Animations",
        navController = navController,
        animate = {  },
        content = {
            val offset = remember { Animatable(Offset(0f, 0f), Offset.VectorConverter) }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        coroutineScope {
                            while (true) {
                                val position = awaitPointerEventScope {
                                    awaitFirstDown().position
                                }
                                launch {
                                    offset.animateTo(position)
                                }
                            }
                        }
                    }
            ) {
                Canvas(modifier = Modifier
                    .size(50.dp)
                    .offset{ offset.value.toIntOffset() }
                ) {
                    drawCircle(color = Color.Black)
                }
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

private fun Offset.toIntOffset() = IntOffset(x.roundToInt(), y.roundToInt())
