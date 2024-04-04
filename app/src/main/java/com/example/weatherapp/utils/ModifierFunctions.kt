package com.example.weatherapp.utils

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

fun Modifier.click(enabled: Boolean = true, onClick: () -> Unit) = clickable(
    interactionSource = androidx.compose.foundation.interaction.MutableInteractionSource(),
    indication = null,
    onClick = onClick,
    enabled = enabled
)