package com.example.tugasil.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasil.data.DataProvider1
import com.example.tugasil.data.DataProvider3.xmen
import com.example.tugasil.data.avengers
import com.example.tugasil.topAppBar.topAppBack

@Composable
fun detailavg(
    modifier : Modifier = Modifier,
    navController: NavController,
    AvengersId : Int?
)
{
    val newavengersList = DataProvider1.avengersList.filter { avengers ->
        avengers.id == AvengersId
    }
    Column(
        modifier = Modifier
    ) {
        DetailavengersContent(newavengersList = newavengersList,navController = navController )
    }
}

@Composable
fun DetailavengersContent(
    newavengersList: List<avengers>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (newavengersList.isNotEmpty()) {
            topAppBack(
                text = newavengersList.first().title,
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                newavengersList.forEach { avengers ->
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = avengers.avengersImageid),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(300.dp)
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp)),
                        Text(text = "Nama : ${avengers.title}")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Deskripsi : ${avengers.description}")
                    }
                }
            }
        } else {
            Text(text = "Tidak ada karakter Avengers yang ditampilkan", modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
        }
    }
}