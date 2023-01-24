package com.example.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modifierdemo.ui.theme.JetPackTheme

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

@Composable
fun DemoScreen() {
    
    val modifier = Modifier
        .padding(all = 10.dp)
        .border(width = 2.dp, color = Color.Black)


    Column {
        Text(
            "Hello Compos",
            modifier = modifier,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        CustomImage(image = R.drawable.vacation)
    }


}


@Composable
fun CustomImage(image: Int, modifier: Modifier = Modifier) {
    Image(painter = painterResource(id = image), contentDescription = null, modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackTheme {
        DemoScreen()
    }
}