package com.gucodero.compose.ui.main_screen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.gucodero.compose.domain.entity.ColorData

data class MainUIState(
    val colors: SnapshotStateList<ColorData> = mutableStateListOf(),
    val title: String = ""
)