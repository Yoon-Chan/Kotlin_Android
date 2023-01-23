package com.example.stateexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateexample.ui.theme.JetPackTheme

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
                    Column {
                        DemoScreen()
                        FunctionA()
                    }
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {
    //remember 사용 시 회전하면 데이터가 삭제되고 비어있는 상태가 되는데
    // rememberSaveable을 사용하면 데이터가 회전이 되는 즉 상태가 변경이 되어도 데이터 값이 유지된다.
    var textState by rememberSaveable {
        mutableStateOf("")
    }

    val onTextChange = {
        text : String ->
        textState = text
    }

    MyTextField(text = textState, onTextChange = onTextChange )
//    MyTextField()
}

@Composable
fun MyTextField(text : String, onTextChange : (String) -> Unit) {
//    var textState by remember { mutableStateOf("") }
//
//    //3.위와 같은 방법
////    var (textValue, setText) = remember {
////        mutableStateOf("")
////    }
//
//    val onTextChange = { text: String ->
//        textState = text
//        //3.위와 같은 방법
//        //setText(text)
//    }

/* 3. value = textValue */
    TextField(value = text, onValueChange = onTextChange)
}


@Composable
fun FunctionA() {
    var switchState by remember {
        mutableStateOf(true)
    }

    val onSwitchChange = { value: Boolean ->
        switchState = value
    }

    FunctionB(switchState = switchState, onSwitchChange = onSwitchChange)
}

@Composable
fun FunctionB(switchState: Boolean, onSwitchChange: (Boolean) -> Unit) {
    Switch(checked = switchState, onCheckedChange = onSwitchChange)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        Column {
            DemoScreen()
            FunctionA()
        }
    }
}