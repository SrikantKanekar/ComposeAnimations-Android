package com.example.animationplayground.ui.animatable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.animationplayground.ui.animatable.AnimatableViewModel.AnimatableStates.*

class AnimatableViewModel : ViewModel() {

    var animationState by mutableStateOf(START)

    fun animate() {
        animationState = if (animationState == START) END else START
    }

    enum class AnimatableStates {
        START, END
    }
}