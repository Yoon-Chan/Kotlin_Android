package com.example.chap38

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.chap38.ui.theme.Chap38Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chap38Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
//                        RotationDemo()
//                        Spacer(modifier = Modifier.height(20.dp))
//                        ColorChageDemo()
                        //MotionDemo()
                        TransitionDemo()
                    }
                }
            }
        }
    }
}

@Composable
fun RotationDemo() {
    var rotated by remember { mutableStateOf(false) }

    val angle by animateFloatAsState(targetValue = if (rotated) 360f else 0f,
            animationSpec = tween(durationMillis = 2500, easing = LinearEasing)
        )

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.propeller), contentDescription = "fan",
            modifier = Modifier
                .rotate(angle)
                .padding(10.dp)
                .size(300.dp)
        )

        Button(onClick = { rotated = !rotated }, modifier = Modifier.padding(10.dp)) {
            Text(text = "Rotate Propeller")
        }
    }
}


enum class BoxColor{
    Red, Magenta
}

@Composable
fun ColorChageDemo(){
    var colorState by remember { mutableStateOf(BoxColor.Red)}

    val animatedColor : Color by animateColorAsState(
        targetValue = when (colorState) {
            BoxColor.Red -> Color.Magenta
            BoxColor.Magenta -> Color.Red
        },
        animationSpec = tween(4500)
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .padding(20.dp)
            .size(200.dp)
            .background(animatedColor))
        
        Button(onClick = {
            colorState = when (colorState) {
                BoxColor.Red -> BoxColor.Magenta
                BoxColor.Magenta -> BoxColor.Red
            }
        }, modifier = Modifier.padding(10.dp)) {
            Text(text = "Chage Color")
        }
    }
}


enum class BoxPosition{
    Start, End
}

@Composable
fun MotionDemo(){
    var screenWidth = (LocalConfiguration.current.screenWidthDp.dp)
    var boxState by remember { mutableStateOf(BoxPosition.Start) }
    val boxSideLength = 70.dp


    val  animatedOffset: Dp by animateDpAsState(targetValue = when(boxState) {
        BoxPosition.Start -> 0.dp
        BoxPosition.End -> screenWidth - boxSideLength
    }, animationSpec = keyframes {
        durationMillis = 1000
        100.dp.at(10)
        110.dp.at(500).with(FastOutLinearInEasing)
        200.dp.at(700).with(LinearEasing)
    }
//    }, animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessVeryLow)

    )
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .offset(x = animatedOffset, y = 20.dp)
            .size(boxSideLength)
            .background(Color.Red))

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            boxState = when(boxState){
                BoxPosition.Start -> BoxPosition.End
                BoxPosition.End -> BoxPosition.Start
            }
        },
        modifier = Modifier
            .padding(20.dp)
            .align(Alignment.CenterHorizontally)) {
            Text(text= "Move Box")
        }
    }
}

@Composable
fun TransitionDemo(){
    var boxState by remember { mutableStateOf(BoxPosition.Start) }
    var screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val boxSideLength = 70.dp

    val transition = updateTransition(targetState = boxState, label = "Color and Motion")

    val animatedColor : Color by transition.animateColor(transitionSpec = { tween(4000) },
        label = "Color"
    ) {
        state ->
        when(state){
            BoxPosition.Start -> Color.Red
            BoxPosition.End -> Color.Magenta
        }
    }

    val animatedOffset : Dp by transition.animateDp(
        transitionSpec = {
            tween(4000)
        },
        label = "Motion"
    ) {
        state ->
        when(state){
            BoxPosition.Start -> 0.dp
            BoxPosition.End -> screenWidth - boxSideLength
        }
    }


    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier
            .offset(x = animatedOffset, y = 20.dp)
            .size(boxSideLength)
            .background(animatedColor))

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            boxState = when(boxState){
                BoxPosition.Start -> BoxPosition.End
                BoxPosition.End -> BoxPosition.Start
            }
        },
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally)) {
            Text(text= "Move Box")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Chap38Theme {
        RotationDemo()
    }
}