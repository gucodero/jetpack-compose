package com.gucodero.compose.ui.main_screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(){
    val viewModel = getViewModel<MainViewModel>()
    Text("Main Screen")
}