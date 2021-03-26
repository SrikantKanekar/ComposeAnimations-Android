package com.example.animationplayground.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animationplayground.model.finiteAnimationSpecList

@Composable
fun SpecTypeRadioButtons(
    currentType: String,
    onClick: (String) -> Unit
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(bottom = 10.dp),
            text = "Spec Type",
            style = MaterialTheme.typography.h5
        )
        for (spec in finiteAnimationSpecList) {
            TextRadioButton(
                selected = currentType == spec,
                text = spec,
                onClick = { onClick(spec) }
            )
        }
    }
}

@Composable
fun EasingRadioButtons(
    currentEasing: Easing,
    onClick: (Easing) -> Unit
) {
    val easingList = listOf(
        FastOutSlowInEasing, LinearOutSlowInEasing, FastOutLinearInEasing, LinearEasing
    )

    val easingText = listOf(
        "FastOutSlowInEasing", "LinearOutSlowInEasing", "FastOutLinearInEasing", "LinearEasing"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(bottom = 5.dp),
            text = "Easing"
        )
        for (easing in easingList) {
            TextRadioButton(
                selected = currentEasing == easing,
                text = easingText[easingList.indexOf(easing)],
                onClick = { onClick(easing) }
            )
        }
    }
}

@Composable
fun TextRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    text: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            modifier = modifier.padding(end = 10.dp),
            selected = selected,
            onClick = onClick
        )
        Text(
            modifier = Modifier.clickable { onClick() },
            text = text
        )
    }
}