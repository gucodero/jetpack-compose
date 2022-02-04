package com.gucodero.compose.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorPicker(
    color: Color,
    selected: Boolean,
    onClick: () -> Unit
){
    val progress by animateFloatAsState(
        targetValue = if(selected) 1f else 0f,
        tween(durationMillis = 1000)
    )
    val borderWidth = (6f * progress + 1).dp
    val modifier = Modifier
        .size(35.dp)
        .background(
            color = color,
            shape = CircleShape
        )
        .run {
            if (selected) {
                border(
                    width = borderWidth,
                    color = Color.Blue,
                    shape = CircleShape
                )
            } else {
                border(
                    width = borderWidth,
                    color = Color.LightGray,
                    shape = CircleShape
                )
            }
        }
        .clickable(
            onClick = onClick,
            interactionSource = remember {
                MutableInteractionSource()
            },
            indication = rememberRipple(
                bounded = false
            )
        )
    Box(
        modifier = modifier
    )
}