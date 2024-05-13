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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tugasil.data.DataProvider1
import com.example.tugasil.data.DataProvider2
import com.example.tugasil.data.DataProvider3.xmen
import com.example.tugasil.data.avengers
import com.example.tugasil.data.spiderman
import com.example.tugasil.topAppBar.topAppBack

@Composable
fun detailspider(
    modifier : Modifier = Modifier,
    navController: NavController,
    SpidermanId : Int?
)
{
    val newspidermanList = DataProvider2.spidermanList.filter { spiderman ->
        spiderman.id == SpidermanId
    }
    Column(
        modifier = Modifier
    ) {
        DetailspidermanContent(newspidermanList = newspidermanList,navController = navController )
    }
}

@Composable
fun DetailspidermanContent(
    newspidermanList: List<spiderman>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (newspidermanList.isNotEmpty()) {
            topAppBack(
                text = newspidermanList.first().title,
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                newspidermanList.forEach { spiderman ->
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = spiderman.spidermanImageid),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                                .width(300.dp)
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Nama : ${spiderman.title}")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Deskripsi : ${spiderman.description}")
                    }
                }
            }
        } else {
            Text(text = "Tidak ada karaakter Spider Man yang ditampilkan", modifier = Modifier.fillMaxWidth().padding(16.dp))
        }
    }
}