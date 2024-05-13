package com.example.tugasil.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasil.data.DataProvider1
import com.example.tugasil.data.DataProvider2
import com.example.tugasil.avgListitem
import com.example.tugasil.spiderListitem
import com.example.tugasil.navigation.Screens
import com.example.tugasil.topAppBar.topAppBar

@Composable
fun screen1(
    navController: NavController
) {
    val avengers = remember {
        DataProvider1.avengersList
    }
    val spiderman = remember {
        DataProvider2.spidermanList
    }
    Column {
        topAppBar(text = "Avengers")
        LazyRow (
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(
                items = avengers, key= {it.id},
                itemContent = {
                    avgListitem(avengers = it){
                            AvengersId -> navController.navigate(Screens.detailavg.name+"/${AvengersId}")
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn (
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(
                items = spiderman,
                itemContent = {
                    spiderListitem(spiderman = it ){
                        SpidermanId -> navController.navigate(Screens.detailspider.name+"/${SpidermanId}")
                    }
                }
            )
        }

    }
}
