package com.example.animationplayground.components.animationSpec

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import com.example.animationplayground.components.SpecTypeRadioButtons
import com.example.animationplayground.model.AnimationSpec

@Composable
fun AnimationSpecController(
    spec: AnimationSpec,
    update: (AnimationSpec) -> Unit
) {
    SpecTypeRadioButtons(
        currentType = spec.type,
        onClick = { update(spec.copy(type = it)) }
    )

    Crossfade(targetState = spec.type) { specType ->
        when (specType) {
            "tween" -> TweenController(spec = spec, update = update)
            "spring" -> SpringController(spec = spec, update = update)
            "snap" -> SnapController(spec = spec, update = update)
        }
    }
}