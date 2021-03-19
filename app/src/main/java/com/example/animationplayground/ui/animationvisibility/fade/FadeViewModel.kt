package com.example.animationplayground.ui.animationvisibility.fade

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FadeViewModel : ViewModel() {
    var animationState by mutableStateOf(true)
    var initialAlpha by mutableStateOf(0f)
    var targetAlpha by mutableStateOf(0f)
    var durationMillis by mutableStateOf(300)

    fun animate() {
        animationState = !animationState
    }
}