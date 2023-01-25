package com.example.listdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listdemo.ui.theme.JetPackTheme
import kotlinx.coroutines.launch
import java.time.format.TextStyle

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
                    Mainscreen()
                }
            }
        }
    }
}

@Composable
fun Mainscreen() {
//    ColumnList()

    RowList()
}

@Composable
fun RowList(){

    val scrollState = rememberScrollState()

    Row(Modifier.horizontalScroll(scrollState)) {

        repeat(50){
            Text("$it",
            modifier = Modifier.padding(5.dp),
            style = MaterialTheme.typography.h4)
        }
    }

}


@Composable
fun ColumnList() {

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(0)
                    }
                },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(2.dp)
            ) {
                Text(text = "Top")
            }

            Button(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(scrollState.maxValue)
                    }
                },
                Modifier
                    .weight(0.5f)
                    .padding(2.dp)
            ) {
                Text("End")
            }

        }

        Column(Modifier.verticalScroll(scrollState)) {
            repeat(500) {
                Text(
                    text = "List Item $it",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

// 리스트 스크롤 활성화 하기
//fun ColumnList(){
//
//    val scrollState = rememberScrollState()
//
//    Column(Modifier.verticalScroll(scrollState)) {
//        repeat(500){
//            Text(text = "List Item $it",
//                style = MaterialTheme.typography.h4,
//                modifier = Modifier.padding(5.dp)
//            )
//        }
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        Mainscreen()
    }
}