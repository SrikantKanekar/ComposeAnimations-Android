package com.example.animationplayground.ui.crossfade

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CrossFadeViewModel : ViewModel() {
    var animationState by mutableStateOf("One")
    var durationMillis by mutableStateOf(300)

    fun animate() {
        if (animationState == "One"){
            animationState = "Two"
        } else{
            animationState = "One"
        }
    }
}