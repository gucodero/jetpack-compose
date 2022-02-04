package com.gucodero.compose.ui.components

import android.widget.ImageView
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun MyAppBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.White
    ) {
        Text(
            text = "Colors",
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }
}