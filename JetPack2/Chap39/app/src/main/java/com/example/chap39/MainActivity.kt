package com.example.chap39

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chap39.ui.theme.Chap39Theme
import kotlin.math.PI
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chap39Theme {
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
    //선 그리기
    //DrawLine()

    //사각형 그리기
    //DrawRect()

    //회전 시키기
    //Rotate()

    //원 그리기
    //DrawCircle()

    //그레디언트 그리기
    //사각형
    //GradientFill()

    //원
    //RadialFill()

    //그림자 효과 표시
    //ShadowCircle()

    //부채꼴 그리기
    //DrawArc()

    //경로 그리기
    //DrawPath()

    //점 그리기
    //DrawPoints()

    //이미지 그리기
    DrawImage()

}

@Composable
fun DrawLine() {
    Canvas(modifier = Modifier.size(300.dp)) {
        //DrawScope가 가지고 있는 크기 프로퍼티 접근 가능.
        val height = size.height
        val width = size.width

        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = width, y = height),
            color = Color.Blue,
            strokeWidth = 16.0f,
            //점선 그리기 속성
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 10f, 10f, 10f), phase = 0f)
        )
    }
}

@Composable
fun DrawRect() {
    Canvas(modifier = Modifier.size(300.dp)) {
        //val size = Size(200.dp.toPx(), 100.dp.toPx())//Size(600f, 250f)
//        drawRect(color = Color.Blue,
//            topLeft = Offset(x=50.dp.toPx() ,y= 300f),
//            size = size / 2f)

//        inset(100f, 200f){
//            drawRect(
//                color = Color.Blue,
//                size = size/ 2f
//            )
//        }

        val size = Size(
            width = 280.dp.toPx(),
            height = 200.dp.toPx(),
        )

        drawRoundRect(
            color = Color.Blue,
            size = size,
            topLeft = Offset(20f, 20f),
            //style : 두께 조절
            style = Stroke(width = 8.dp.toPx()),
            cornerRadius = CornerRadius(
                x = 30.dp.toPx(),
                y = 30.dp.toPx()
            )
        )
    }
}

@Composable
fun Rotate() {
    Canvas(modifier = Modifier.size(300.dp)) {
        rotate(45f) {
            drawRect(
                color = Color.Blue,
                size = size / 2f,
                topLeft = Offset(200f, 200f)
            )
        }
    }
}

@Composable
fun DrawCircle() {
    //원 그리기
//    Canvas(modifier = Modifier.size(300.dp)){
//        val canvasWidth = size.width
//        val canvasHeight = size.height
//
//        drawCircle(
//            color = Color.Blue,
//            center = center,
//            radius = 120.dp.toPx()
//        )
//    }

    //타원 그리기
    Canvas(modifier = Modifier.size(300.dp)) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawOval(
            color = Color.Blue,
            topLeft = Offset(25.dp.toPx(), 90.dp.toPx()),
            size = Size(width = canvasWidth - 50.dp.toPx(),
            height = canvasHeight/2 - 50.dp.toPx()),
            style = Stroke(width = 12.dp.toPx())
        )
    }
}

@Composable
fun GradientFill(){
    Canvas(modifier = Modifier.size(300.dp) ){
        val canvasSize = size

        val colorList : List<Color> = listOf(Color.Red, Color.Blue, Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)

        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0f,
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawRect(
            brush = brush,
            size = canvasSize
        )
    }
}

@Composable
fun RadialFill(){
    Canvas(modifier = Modifier.size(300.dp) ){
        val canvasWidth = size.width
        val canvasHeight = size.height
        val radius = 150.dp.toPx()
        val colorList : List<Color> = listOf(Color.Red, Color.Blue, Color.Magenta, Color.Yellow, Color.Green, Color.Cyan)

        val brush = Brush.radialGradient(
            colors = colorList,
            center = center,
            radius = radius,
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            center = center,
            radius = radius
        )
    }
}

@Composable
fun ShadowCircle(){
    Canvas(modifier = Modifier.size(300.dp) ){
        val radius = 150.dp.toPx()
        val colorList : List<Color> = listOf(Color.Blue, Color.Black)

        val brush = Brush.horizontalGradient(
            colors = colorList,
            startX = 0.dp.toPx(),
            endX = 300.dp.toPx(),
            tileMode = TileMode.Repeated
        )

        drawCircle(
            brush = brush,
            radius = radius
        )
    }

}

@Composable
fun DrawArc(){
    Canvas(modifier = Modifier.size(300.dp) ){
        drawArc(
            color = Color.Blue,
            size = Size(width = 250.dp.toPx(), height = 250.dp.toPx()),
            startAngle = 20f,
            //sweepAngle : 내각의 각도
            sweepAngle = 90f,
            useCenter = true,
        )
    }
}

@Composable
fun DrawPath(){
    Canvas(modifier = Modifier.size(300.dp)){
        val path = Path().apply {
            moveTo(0f, 0f)
            quadraticBezierTo(50.dp.toPx(), 200.dp.toPx(),
            300.dp.toPx(), 300.dp.toPx())
            lineTo(270.dp.toPx(), 100.dp.toPx())
            quadraticBezierTo(60.dp.toPx(), 80.dp.toPx(), 0f, 0f)
            close()
        }

        drawPath(
            path = path,
            color = Color.Blue
        )
    }
}

@Composable
fun DrawPoints(){
    Canvas(modifier = Modifier.size(300.dp) ){
        val height = size.height
        val width = size.width
        val points = mutableListOf<Offset>()

        for(x in 0..size.width.toInt()){
            val y = (sin(x * (2f * PI / width)) * (height / 2) + (height / 2)).toFloat()
            points.add(Offset(x.toFloat(), y))
        }

        drawPoints(
            points = points,
            strokeWidth = 3f,
            pointMode = PointMode.Points,
            color = Color.Blue
        )
    }
}

@Composable
fun DrawImage(){
    val image = ImageBitmap.imageResource(id = R.drawable.vacation)

    Canvas(modifier = Modifier.size(360.dp, 270.dp) ){
        drawImage(
            image = image,
            topLeft = Offset(x= 0f, y = 0f),
            colorFilter = ColorFilter.tint(
                color = Color(0xADFFAA2E),
                blendMode = BlendMode.ColorBurn
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Chap39Theme {
        MainScreen()
    }
}