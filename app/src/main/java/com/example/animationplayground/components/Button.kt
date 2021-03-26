package com.example.animationplayground.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.width(250.dp),
        onClick = onClick,
        shape = CircleShape
    ) {
        Text(text = text)
    }
}