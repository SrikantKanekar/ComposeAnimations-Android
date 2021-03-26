package com.example.animationplayground.ui.updateTransition

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.animationplayground.ui.updateTransition.UpdateTransitionViewModel.TransitionState.*

class UpdateTransitionViewModel : ViewModel() {

    var animationState by mutableStateOf(START)

    fun animate() {
        animationState = when (animationState) {
            START -> MIDDLE
            MIDDLE -> END
            END -> START
        }
    }

    enum class TransitionState {
        START, MIDDLE, END
    }
}