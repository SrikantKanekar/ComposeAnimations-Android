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
fun SnapController(
    spec: AnimationSpec,
    update: (AnimationSpec) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Snap",
            style = MaterialTheme.typography.h6
        )
        TextSlider(
            text = "Snap Delay",
            value = spec.snap.delayMillis.toFloat(),
            onValueChange = { update(spec.copy(snap = spec.snap.copy(delayMillis = it.toInt()))) },
            valueRange = 0f..3000f
        )
    }
}