package com.example.animationplayground.util

import androidx.compose.animation.core.*
import com.example.animationplayground.model.AnimationSpec

class MyAnimationSpec(private val data: AnimationSpec) {

    fun <T> finiteAnimationSpec(): FiniteAnimationSpec<T> {
        return when (data.type) {
            "tween" -> {
                tween(
                    durationMillis = data.tween.durationMillis,
                    delayMillis = data.tween.delayMillis,
                    easing = data.tween.easing
                )
            }
            "spring" -> {
                spring(
                    dampingRatio = data.spring.dampingRatio,
                    stiffness = data.spring.stiffness,
                    visibilityThreshold = null
                )
            }
            "snap" -> {
                snap(delayMillis = data.snap.delayMillis)
            }
            else -> {
                keyframes {
                    durationMillis = data.keyframes.durationMillis
                    delayMillis = data.keyframes.delayMillis
                }
            }
        }
    }
}
