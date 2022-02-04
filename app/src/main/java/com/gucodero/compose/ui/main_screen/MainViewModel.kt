package com.gucodero.compose.ui.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.gucodero.compose.domain.entity.ColorData

class MainViewModel: ViewModel() {

    val state by mutableStateOf(MainUIState())

    fun createColor(colorData: ColorData){
        state.colors.add(colorData)
    }

    fun deleteColor(id: Int){
        state.colors.removeAt(id)
    }

}