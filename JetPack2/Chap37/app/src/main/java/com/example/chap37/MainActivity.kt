package com.example.chap37


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chap37.ui.theme.Chap37Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chap37Theme {
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen() {
    var boxVisible by remember { mutableStateOf(true) }

    val onClick = { newState: Boolean ->
        boxVisible = newState
    }

    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Crossfade(
                targetState = boxVisible,
                animationSpec = tween(5000)
            ) { visible ->
                when (visible) {
                    true -> CustomButton(
                        text = "Hide",
                        targetState = false,
                        onClick = onClick,
                        bgColor = Color.Red
                    )
                    false -> CustomButton(
                        text = "Show",
                        targetState = true,
                        onClick = onClick,
                        bgColor = Color.Magenta
                    )
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        println(boxVisible)

        AnimatedVisibility(
            visible = boxVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 5500)),
            exit = fadeOut(animationSpec = tween(durationMillis = 5500))
        ) {
            Box(
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .background(color = Color.Blue)
            )
        }
    }

}

@Composable
fun CustomButton(
    text: String,
    targetState: Boolean,
    onClick: (Boolean) -> Unit,
    bgColor: Color = Color.Blue
) {
    Button(
        onClick = { onClick(targetState) },
        colors = ButtonDefaults.buttonColors(backgroundColor = bgColor, contentColor = Color.White)
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Chap37Theme {
        MainScreen()
    }
}