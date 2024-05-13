package com.example.tugasil.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasil.data.DataProvider3
import com.example.tugasil.data.xmen
import com.example.tugasil.navigation.Screens
import com.example.tugasil.topAppBar.topAppBar
import com.example.tugasil.xmenListitem

@Composable
fun screen2(
    navController: NavController
) {
    val xmen = remember {
        DataProvider3.xmenList
    }
    Column {
        topAppBar(text = "X Men")
        LazyVerticalGrid(
            contentPadding = PaddingValues(40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = xmen,
                itemContent = {
                    xmenListitem(xmen = it){
                            XmenId -> navController.navigate(Screens.detailxmen.name+"/${XmenId}")
                    }
                }
            )
        }
    }
}