package com.example.animationplayground.ui.animationvisibility.expand

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ExpandViewModel : ViewModel() {

    var animationState by mutableStateOf(true)
    var clip by mutableStateOf(true)
    var durationMillis by mutableStateOf(300)

    fun animate() {
        animationState = !animationState
    }
}