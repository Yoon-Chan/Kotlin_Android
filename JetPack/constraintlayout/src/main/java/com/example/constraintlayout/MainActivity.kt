package com.example.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.constraintlayout.ui.theme.JetPackTheme

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

@Composable
fun MainScreen() {
//    val constraints = myConstraintSet(margin = 8.dp)
//    ConstraintLayout(constraints, Modifier.size(width = 200.dp, height = 200.dp)) {
//        MyButton(text = "Button1", Modifier.size(200.dp).layoutId("button1"))

    ConstraintLayout( Modifier.size(width = 200.dp, height = 200.dp)) {

        val button1 = createRef()
        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(parent.start, parent.end, startMargin = 8.dp, endMargin = 8.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints

        })


//        val (button1, button2, button3) = createRefs()
//
//
//        val barrier = createEndBarrier(button1,button2)
//
//        MyButton(text = "Button1", Modifier.constrainAs(button1) {
//            top.linkTo(parent.top, margin = 30.dp)
//            start.linkTo(parent.start, margin = 8.dp)
//        })
//
//        MyButton(text = "Button2", Modifier.constrainAs(button2) {
//            top.linkTo(button1.bottom, margin = 20.dp)
//            start.linkTo(parent.start, margin = 8.dp)
//        })
//
//        MyButton(text = "Button3", Modifier.constrainAs(button3) {
//            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
//            end.linkTo(parent.end, margin = 8.dp)
//            start.linkTo(barrier, margin = 30.dp)
//            width = Dimension.fillToConstraints
//            height = Dimension.fillToConstraints
//        })
//        //가이드라인 이용하기
//        //영역 시작 지점에서 25% 거리
////        createGuidelineFromStart(0.25f)
//        val guide = createGuidelineFromStart(0.60f)
//
//
//        //부모 아래쪽 가장자리에서 60dp 거리
//        //createGuidelineFromBottom(offset = 60.dp)
//
//        MyButton(text = "Button1", Modifier.constrainAs(button1) {
//            top.linkTo(parent.top, margin = 30.dp)
//            end.linkTo(guide)
//        })
//
//        MyButton(text = "Button2", Modifier.constrainAs(button2) {
//            top.linkTo(button1.bottom, margin = 20.dp)
//            start.linkTo(guide, margin = 40.dp)
//        })
//
//        MyButton(text = "Button3", Modifier.constrainAs(button3) {
//            top.linkTo(button2.bottom, margin = 40.dp)
//            end.linkTo(guide, margin = 20.dp)
//        })


//        createHorizontalChain(button1, button2, button3 , chainStyle = ChainStyle.SpreadInside)
//
//        MyButton(text = "Button1", Modifier.constrainAs(button1) {
//            centerHorizontallyTo(parent)
//        })
//
//
//        MyButton(text = "Button2", Modifier.constrainAs(button2) {
//            centerHorizontallyTo(parent)
//        })
//
//
//        MyButton(text = "Button3", Modifier.constrainAs(button3) {
//            centerHorizontallyTo(parent)
//        })


//        MyButton(text = "Button1", Modifier.constrainAs(button1){
//
//            centerHorizontallyTo(parent)
//            top.linkTo(parent.top, margin = 60.dp)
//            linkTo(start = parent.start, end = parent.end, endMargin = 50.dp, startMargin = 30.dp)

//            centerHorizontallyTo(parent)
//            centerVerticallyTo(parent)

//            top.linkTo(parent.top, margin = 60.dp)
//            linkTo(
//                parent.start,
//                parent.end
//            )
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//            start.linkTo(parent.start, margin = 30.dp)
//        })

//        MyButton(text = "Button2", Modifier.constrainAs(button2){
//            centerHorizontallyTo(parent)
//            top.linkTo(button1.bottom)
//            bottom.linkTo(parent.bottom)
//        })


    }


}


private fun myConstraintSet(margin : Dp) : ConstraintSet {
    return ConstraintSet {
        val button1 = createRefFor("button1")

        constrain(button1) {
            linkTo(parent.top, parent.bottom, topMargin = margin, bottomMargin = margin)
            linkTo(parent.start, parent.end, startMargin = margin, endMargin = margin)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
}


@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
    ) {
        Text(text)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        MainScreen()
    }
}