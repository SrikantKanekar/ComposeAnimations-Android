package com.example.animationplayground.components.animationSpec

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animationplayground.components.TextSlider
import com.example.animationplayground.model.AnimationSpec

@Composable
fun SpringController(
    spec: AnimationSpec,
    update: (AnimationSpec) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Spring",
            style = MaterialTheme.typography.h6
        )
        TextSlider(
            text = "Damping ratio",
            value = spec.spring.dampingRatio,
            onValueChange = { update(spec.copy(spring = spec.spring.copy(dampingRatio = it))) },
            valueRange = 0.1f..1f
        )

        TextSlider(
            text = "Stiffness",
            value = spec.spring.stiffness,
            onValueChange = { update(spec.copy(spring = spec.spring.copy(stiffness = it))) },
            valueRange = 50f..10_000f
        )
    }
}