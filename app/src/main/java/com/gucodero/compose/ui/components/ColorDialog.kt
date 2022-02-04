package com.gucodero.compose.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gucodero.compose.domain.entity.ColorData
import com.gucodero.compose.ui.main_screen.LocalViewModel

private val listColor = listOf<ColorData>(
    ColorData(
        color = Color.Gray,
        name = "Gris"
    ),
    ColorData(
        color = Color.Red,
        name = "Rojo"
    ),
    ColorData(
        color = Color.Green,
        name = "Verde"
    ),
    ColorData(
        color = Color.Black,
        name = "Negro"
    ),
    ColorData(
        color = Color.White,
        name = "Blanco"
    ),
    ColorData(
        color = Color.Blue,
        name = "Azul"
    ),
    ColorData(
        color = Color.Yellow,
        name = "Amarillo"
    ),
    ColorData(
        color = Color.Cyan,
        name = "No se"
    )
)


@Composable
fun ColorDialog(
    onClose: () -> Unit
){
    var selectedColor by remember {
        mutableStateOf<ColorData?>(null)
    }
    val viewModel = LocalViewModel.current
    val color by animateColorAsState(
        targetValue = if(selectedColor != null) MaterialTheme.colors.primary else Color.LightGray,
        tween(durationMillis = 2000)
    )
    Dialog(
        onDismissRequest = onClose
    ) {
        BoxWithConstraints() {
            maxWidth
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(21.dp)
                )
                .padding(16.dp)
        ) {
            Column {
                Column(
                    modifier = Modifier.heightIn(min = 140.dp)
                ) {
                    listColor.chunked(4).forEach { sublist ->
                        Row {
                            sublist.forEach {
                                Box(
                                    modifier = Modifier.weight(1f),
                                    contentAlignment = Alignment.Center
                                ) {
                                    ColorPicker(
                                        color = it.color,
                                        selected = selectedColor == it,
                                        onClick = {
                                            selectedColor = if(selectedColor != it){
                                                it
                                            } else {
                                                null
                                            }
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                Button(
                    onClick = {
                        selectedColor?.let {
                            viewModel.createColor(
                                colorData = it
                            )
                        }
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = color
                    )
                ) {
                    Text("Agregar")
                }
            }
        }
    }
}