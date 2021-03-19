package com.example.animationplayground.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.inset
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animationplayground.theme.AnimationPlaygroundTheme
import com.example.animationplayground.ui.animationvisibility.expand.ExpandScreen
import com.example.animationplayground.ui.animationvisibility.expand.ExpandViewModel
import com.example.animationplayground.ui.animationvisibility.fade.FadeScreen
import com.example.animationplayground.ui.animationvisibility.fade.FadeViewModel
import com.example.animationplayground.ui.crossfade.CrossFadeScreen
import com.example.animationplayground.ui.crossfade.CrossFadeViewModel
import com.example.animationplayground.ui.home.HomeScreen

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
                }
            }
        }
    }
}
