package com.example.animationplayground.ui.animationvisibility.expand

import androidx.compose.animation.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animationplayground.components.animationSpec.AnimationSpecController
import com.example.animationplayground.components.MyBottomSheetScaffold
import com.example.animationplayground.components.TextSwitch
import com.example.animationplayground.util.MyAnimationSpec

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ExpandScreen(
    viewModel: ExpandViewModel,
    navController: NavHostController
) {
    val animationSpec = viewModel.animationSpecFlow.collectAsState()

    MyBottomSheetScaffold(
        title = "Expand/shrink Animation",
        navController = navController,
        animate = { viewModel.animate() },
        content = {
            AnimatedVisibility(
                modifier = Modifier.align(Alignment.Center),
                visible = viewModel.animationState,
                enter = expandIn(
                    animationSpec = MyAnimationSpec(animationSpec.value).finiteAnimationSpec(),
                    clip = viewModel.clip
                ),
                exit = shrinkOut(
                    animationSpec = MyAnimationSpec(animationSpec.value).finiteAnimationSpec(),
                    clip = viewModel.clip
                )
            ) {
                Canvas(modifier = Modifier.size(70.dp)) {
                    drawRect(color = Color.Black)
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

                AnimationSpecController(
                    spec = animationSpec.value,
                    update = { viewModel.update(it) }
                )

                TextSwitch(
                    text = "Clip",
                    checked = viewModel.clip,
                    onCheckedChanged = { viewModel.clip = it }
                )
            }
        }
    )
}