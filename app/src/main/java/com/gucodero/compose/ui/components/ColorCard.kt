package com.gucodero.compose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorCard(
    modifier: Modifier = Modifier,
    name: String,
    color: Color,
    onDelete: () -> Unit
){
    Card(
        modifier = modifier
            .height(80.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = color),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(
                        color = Color.Black.copy(
                            alpha = 0.2f
                        )
                    )
                    .padding(12.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Text(
                    text = name,
                    fontSize = 21.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Box(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .weight(1f),
                contentAlignment = Alignment.CenterEnd
            ){
                IconButton(
                    onClick = onDelete
                ) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
    }
}