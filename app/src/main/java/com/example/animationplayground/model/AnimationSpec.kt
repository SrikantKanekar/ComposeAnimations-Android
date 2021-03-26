package com.example.animationplayground.model

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AnimationSpecData {
    private val _data = MutableStateFlow(AnimationSpec())

    val data: StateFlow<AnimationSpec> = _data

    fun update(newData: AnimationSpec){
        _data.value = newData
    }
}

data class AnimationSpec(
    val type: String = finiteAnimationSpecList.first(),
    val tween: Tween = Tween(),
    val spring: Spring = Spring(),
    val keyframes: Keyframes = Keyframes(),
    val snap: Snap = Snap()
)

data class Tween(
    val durationMillis: Int = 300,
    val delayMillis: Int = 0,
    val easing: Easing = FastOutSlowInEasing
)

data class Spring(
    val dampingRatio: Float = 1F,
    val stiffness: Float = 1F,
    val visibilityThreshold: Any? = null
)

data class Keyframes(
    val durationMillis: Int = 300,
    val delayMillis: Int = 0
)

data class Snap(
    val delayMillis: Int = 0
)

val finiteAnimationSpecList = listOf("tween", "spring", "snap")
