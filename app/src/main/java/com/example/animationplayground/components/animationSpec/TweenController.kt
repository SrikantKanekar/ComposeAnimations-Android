package com.example.animationplayground.components.animationSpec

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animationplayground.components.EasingRadioButtons
import com.example.animationplayground.components.TextSlider
import com.example.animationplayground.model.AnimationSpec

@Composable
fun TweenController(
    spec: AnimationSpec,
    update: (AnimationSpec) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier,
            text = "Tween",
            style = MaterialTheme.typography.h6
        )
        TextSlider(
            text = "Duration in Millis",
            value = spec.tween.durationMillis.toFloat(),
            onValueChange = { update(spec.copy(tween = spec.tween.copy(durationMillis = it.toInt()))) },
            valueRange = 0f..3000f
        )

        TextSlider(
            text = "Delay in Millis",
            value = spec.tween.delayMillis.toFloat(),
            onValueChange = { update(spec.copy(tween = spec.tween.copy(delayMillis = it.toInt()))) },
            valueRange = 0f..3000f
        )

        EasingRadioButtons(
            currentEasing = spec.tween.easing,
            onClick = { update(spec.copy(tween = spec.tween.copy(easing = it))) }
        )
    }
}