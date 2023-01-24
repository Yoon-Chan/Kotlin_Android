package com.example.customlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customlayout.ui.theme.JetPackTheme

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
                    MainScreen()
                }
            }
        }
    }
}

//커스텀 레이아웃 만들기
@Composable
fun CascadeLayout(
    spacing : Int = 0,
    modifier: Modifier = Modifier,
    content : @Composable () -> Unit
){
    Layout(modifier = modifier,
    content = content){
        measureables, constraints ->

        var indent = 0

        layout(constraints.maxWidth, constraints.maxHeight){
            var yCoord = 0
            //자식들 요소를 계산
            val placeables = measureables.map { measureable ->
                measureable.measure(constraints)
            }

            //자식들의 반복 구문
            placeables.forEach {placeable ->  
                placeable.placeRelative(x= indent, y = yCoord)
                indent += placeable.width + spacing
                yCoord += placeable.height + spacing
            }
        }
    }
}


@Composable
fun MainScreen() {

    Box {
        CascadeLayout(spacing = 20) {
            Box(modifier = Modifier.size(60.dp).background(Color.Blue))
            Box(modifier = Modifier.size(80.dp).background(Color.Red))
            Box(modifier = Modifier.size(90.dp).background(Color.Cyan))
            Box(modifier = Modifier.size(50.dp).background(Color.Magenta))
            Box(modifier = Modifier.size(70.dp).background(Color.Green))
            
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        MainScreen()
    }
}