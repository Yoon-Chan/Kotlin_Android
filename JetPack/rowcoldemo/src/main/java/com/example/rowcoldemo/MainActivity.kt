package com.example.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rowcoldemo.ui.theme.JetPackTheme

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

    Row{
        TextCell(text = "1", Modifier.weight(0.2f, true))
        TextCell(text = "2", Modifier.weight(weight = 0.4f, fill = true))
        TextCell(text = "3", Modifier.weight(0.3f, true))
    }


//    Row {
//        Text(
//            "Large Text \n More Text",
//            Modifier.alignBy(LastBaseline),
//            fontSize = 40.sp,
//            fontWeight = FontWeight.Bold,
//
//        )
//
//        Text(
//            "Small Text",
//            modifier = Modifier.paddingFrom(
//                alignmentLine = FirstBaseline,
//                before = 80.dp, after = 0.dp
//            ),
//            fontSize = 32.sp,
//            fontWeight = FontWeight.Bold
//
//        )
//    }


    //    Row(modifier = Modifier.height(300.dp)
//        ) {
//        TextCell(text = "1", Modifier.align(Alignment.Top))
//        TextCell(text = "2", Modifier.align(Alignment.CenterVertically))
//        TextCell(text = "3", Modifier.align(Alignment.Bottom))
//    }
}


@Composable
fun TextCell(text: String, modifier: Modifier = Modifier) {
    val cellModifier = Modifier
        .padding(4.dp)
        .size(100.dp, 100.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(
        text = text,
        cellModifier.then(modifier),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        MainScreen()
    }
}