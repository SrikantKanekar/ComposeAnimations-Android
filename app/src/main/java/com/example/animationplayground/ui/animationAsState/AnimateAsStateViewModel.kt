package com.example.animationplayground.ui.animationAsState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.animationplayground.ui.animationAsState.AnimateAsStateViewModel.AnimateAsStateStates.*

class AnimateAsStateViewModel : ViewModel() {

    var animationState by mutableStateOf(START)

    var startValue by mutableStateOf(0F)
    var endValue by mutableStateOf(1F)

    fun animate() {
        animationState = if (animationState == START) END else START
    }

    enum class AnimateAsStateStates {
        START, END
    }
}