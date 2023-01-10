package com.example.ex1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ex1.ui.theme.JetPackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun CustomSwitch(){
    val checked = remember {
        mutableStateOf(true)
    }

    Column{
        Switch(checked = checked.value, onCheckedChange = {checked.value = it})

        if(checked.value){
            Text("Switch is On")
        }else{
            Text("Switch is Off")
        }
    }
}

@Composable
fun CustomList(items : List<String>){
    Column {
        for (item in items){
            Text(text = item)
            Divider(color = Color.Black)
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        //Greeting("Android")
        //CustomSwitch()
        CustomList(items = listOf("One","Two", "Three", "Four", "Five", "Six","Seven"))
    }
}