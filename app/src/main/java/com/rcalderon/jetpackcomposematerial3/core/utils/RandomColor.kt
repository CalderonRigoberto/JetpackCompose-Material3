package com.rcalderon.jetpackcomposematerial3.core.utils

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object RandomColor {
    fun randomColor(): Color {
        return Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue = Random.nextFloat(),
            alpha = 1f
        )
    }
}
