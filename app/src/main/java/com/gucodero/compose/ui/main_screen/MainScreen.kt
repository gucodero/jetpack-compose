package com.gucodero.compose.ui.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gucodero.compose.ui.components.ColorCard
import com.gucodero.compose.ui.components.ColorDialog
import com.gucodero.compose.ui.components.MyAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = getViewModel()
) = with(viewModel.state){
    var showDialog by remember {
        mutableStateOf(false)
    }
    if(showDialog){
        CompositionLocalProvider(LocalViewModel provides viewModel) {
            ColorDialog(
                onClose = {
                    showDialog = false
                }
            )
        }
    }
    LaunchedEffect(colors.size){
        showDialog = false
    }
    Scaffold(
        topBar = { MyAppBar() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(Icons.Filled.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            itemsIndexed(colors) { index, colorData ->
                Column {
                    ColorCard(
                        name = colorData.name,
                        color = colorData.color,
                        onDelete = {
                            viewModel.deleteColor(
                                id = index
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

val LocalViewModel = compositionLocalOf<MainViewModel>() { error("asd") }

@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()
}