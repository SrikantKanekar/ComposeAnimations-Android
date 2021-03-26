package com.example.animationplayground.ui.animationvisibility.expand

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.animationplayground.model.AnimationSpec
import com.example.animationplayground.model.AnimationSpecData

class ExpandViewModel : ViewModel() {

    private val animationSpec = AnimationSpecData()
    val animationSpecFlow = animationSpec.data

    fun update(newData: AnimationSpec){
        animationSpec.update(newData)
    }

    var animationState by mutableStateOf(true)
    var clip by mutableStateOf(true)

    fun animate() {
        animationState = !animationState
    }
}