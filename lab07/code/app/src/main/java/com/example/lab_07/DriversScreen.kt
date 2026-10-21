package com.example.lab_07

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
@Composable
fun DriversScreen(navController: NavController){

    var drivers by remember{
        mutableStateOf("")
    }
    var driversList = remember{
        mutableStateListOf<String>()
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.testTag("backButton")
        ){
            Text("Back")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Formula Zero Drivers",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            TextField(
                value = drivers,
                onValueChange = {
                    drivers = it
                },
                label = {
                    Text("Drivers")
                },
                modifier = Modifier.testTag("driverInput")

            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    if (drivers.isNotBlank()) {
                        driversList.add(drivers)
                        drivers = ""
                    }
                },
                modifier = Modifier.testTag("addDriverButton")
            ) {
                Text("Add")
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                driversList.clear()
            },
            modifier = Modifier.testTag("clearInput")
        ){
            Text("Clear")
        }

            LazyColumn{
                items(driversList){driver ->
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = driver,
                        fontSize = 24.sp
                    )

                }
            }


    }

}