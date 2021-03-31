package com.example.animationplayground.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animationplayground.theme.AnimationPlaygroundTheme
import com.example.animationplayground.ui.animatable.AnimatableScreen
import com.example.animationplayground.ui.animatable.AnimatableViewModel
import com.example.animationplayground.ui.animationAsState.AnimateAsStateScreen
import com.example.animationplayground.ui.updateTransition.UpdateTransitionViewModel
import com.example.animationplayground.ui.animationAsState.AnimateAsStateViewModel
import com.example.animationplayground.ui.animationvisibility.expand.ExpandScreen
import com.example.animationplayground.ui.animationvisibility.expand.ExpandViewModel
import com.example.animationplayground.ui.animationvisibility.fade.FadeScreen
import com.example.animationplayground.ui.animationvisibility.fade.FadeViewModel
import com.example.animationplayground.ui.crossfade.CrossFadeScreen
import com.example.animationplayground.ui.crossfade.CrossFadeViewModel
import com.example.animationplayground.ui.gestures.GesturesScreen
import com.example.animationplayground.ui.gestures.SwipeToDismissScreen
import com.example.animationplayground.ui.gestures.TransformableScreen
import com.example.animationplayground.ui.infiniteTransition.InfiniteTransitionScreen
import com.example.animationplayground.ui.infiniteTransition.InfiniteTransitionViewModel
import com.example.animationplayground.ui.updateTransition.UpdateTransitionScreen

@ExperimentalMaterialApi
@ExperimentalAnimationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationPlaygroundTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Home") {
                    composable(route = "Home") {
                        HomeScreen(navController = navController)
                    }
                    composable(route = "FadeScreen") {
                        val viewModel: FadeViewModel = viewModel()
                        FadeScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "ExpandScreen") {
                        val viewModel: ExpandViewModel = viewModel()
                        ExpandScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "CrossFadeScreen") {
                        val viewModel: CrossFadeViewModel = viewModel()
                        CrossFadeScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "AnimateAsStateScreen") {
                        val viewModel: AnimateAsStateViewModel = viewModel()
                        AnimateAsStateScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "AnimatableScreen") {
                        val viewModel: AnimatableViewModel = viewModel()
                        AnimatableScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "UpdateTransitionScreen") {
                        val viewModel: UpdateTransitionViewModel = viewModel()
                        UpdateTransitionScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "InfiniteTransitionScreen") {
                        val viewModel: InfiniteTransitionViewModel = viewModel()
                        InfiniteTransitionScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                    composable(route = "GestureScreen") {
                        GesturesScreen(navController = navController)
                    }
                    composable(route = "SwipeToDismissScreen") {
                        SwipeToDismissScreen(navController = navController)
                    }
                    composable(route = "TransformableScreen") {
                        TransformableScreen(navController = navController)
                    }
                }
            }
        }
    }
}
