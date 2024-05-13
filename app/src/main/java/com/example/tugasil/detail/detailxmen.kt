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
import com.example.tugasil.data.DataProvider3
import com.example.tugasil.data.xmen
import com.example.tugasil.topAppBar.topAppBack

@Composable
fun detailxmen(
    modifier : Modifier = Modifier,
    navController: NavController,
    XmenId : Int?
)
{
    val newxmenList = DataProvider3.xmenList.filter { xmen ->
        xmen.id == XmenId
    }
    Column(
        modifier = Modifier
    ) {
        DetailxmenContent(newxmenList = newxmenList,navController = navController )
    }
}

@Composable
fun DetailxmenContent(
    newxmenList: List<xmen>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        if (newxmenList.isNotEmpty()) {
            topAppBack(
                text = newxmenList.first().title,
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                newxmenList.forEach { xmen ->
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = xmen.xmenImageid),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                                .width(300.dp)
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Nama : ${xmen.title}")
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = "Deskripsi : ${xmen.description}")
                    }
                }
            }
        } else {
            Text(text = "Tidak ada karakter X-Men yang ditampilkan", modifier = Modifier.fillMaxWidth().padding(16.dp))
        }
    }
}