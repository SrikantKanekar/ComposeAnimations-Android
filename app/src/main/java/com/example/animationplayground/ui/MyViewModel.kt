package com.example.animationplayground.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

@ExperimentalAnimationApi
class MyViewModel : ViewModel() {

    var visible by mutableStateOf(true)
    var initialAlpha by mutableStateOf(0f)
    var targetAlpha by mutableStateOf(0f)
    var durationMillis by mutableStateOf(300)

    fun toggleVisibility() {
        visible = !visible
    }
}