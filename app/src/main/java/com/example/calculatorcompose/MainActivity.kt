package com.example.calculatorcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Calculate()
        }
    }


    @Preview
    @Composable
    fun Calculate(){

        var num1 by remember {
            mutableStateOf("")
        }
        var num2 by remember {
            mutableStateOf("")
        }


        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = num1 , onValueChange = {
                num1 = it

            }, label = {
                Text(text = "Number One")
            })
            Spacer(modifier = Modifier.padding(10.dp))


            OutlinedTextField(value = num2, onValueChange = {
                num2 = it
            }, label = {
                Text(text = "Number Two")
            })

            Spacer(modifier = Modifier.padding(10.dp))

            Row(

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = {
                    val result = num1.toInt()+num2.toInt()
                    Toast.makeText(applicationContext,"Result : $result", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "+")
                }

                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    val result = num1.toInt()-num2.toInt()
                    Toast.makeText(applicationContext,"Result : $result", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "-")
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    val result = num1.toInt()*num2.toInt()
                    Toast.makeText(applicationContext,"Result : $result", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "*")
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Button(onClick = {
                    val result = num1.toInt()/num2.toInt()
                    Toast.makeText(applicationContext,"Result : $result", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "/")
                }




            }
        }
    }
}

