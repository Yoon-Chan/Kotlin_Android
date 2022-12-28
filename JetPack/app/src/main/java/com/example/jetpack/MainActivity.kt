package com.example.jetpack

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.ui.theme.JetPackTheme

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
                    DemoScreen()
                }
            }
        }
    }
}

//이 애너테이션은 이 함수가 컴포저블 함수임을 시스템에 알린다.
@Composable
fun DemoText(message: String, fontSize: Float) {
    //내장된 컴포저블인 Text
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit) {
    /*
    *  modifier는 Modifier인스턴스로 슬라이더 주위에 패딩 공간을 추가한다.
    *   Modifier는 컴포지에 내장된 코틀린 클래스이며, 단일 객체 안에서 컴포저블에 광범위한 프로퍼티를 설정할 수 있다.
    *
    *   valueRange : 슬라이더값의 범위를 지정한다.
    *   value : 슬라이더의 값을 호출자가 전달한 위치로 설정한다. 이를 이용하면 DemonSlider를 재구성할 때마다 마지막 위칫값을 유지할 수 있다.
    *
    *   onValueChange : Slider의 onValueChange 파라미터를 이용해 나중에 호출할 때 DemoSlider 컴포저블에 전달할 함수 또는 람다를 호출한다.
    *
    * */
    Slider(
        value = sliderPosition,
        onValueChange = onPositionChange  /* 같은 방법 : { onPositionChange(it) }*/,
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..40f
    )
}

@Composable
fun DemoScreen() {
    var sliderPosition by remember { mutableStateOf(20f) }

    val handlePositionChange = { position: Float ->
        sliderPosition = position
    }

    //Column은 레이아웃 정렬을 설정하는 파라미터를 받을 수 있다.
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DemoText(message = "Welcome to Compose", fontSize = sliderPosition)

        Spacer(modifier = Modifier.height(150.dp))

        DemoSlider(sliderPosition = sliderPosition, onPositionChange = handlePositionChange)

        Text(
            text = sliderPosition.toInt().toString() + "sp",
            style = MaterialTheme.typography.h2
        )
    }
}

@Preview
@Composable
fun Preview(){
    JetPackTheme {
        DemoScreen()
    }
}