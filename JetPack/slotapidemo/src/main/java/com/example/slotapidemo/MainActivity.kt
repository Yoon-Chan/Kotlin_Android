package com.example.slotapidemo

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slotapidemo.ui.theme.JetPackTheme

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

    //이 변수와 Click은 Checkbox 컴포넌트의 상태를 true로 설정한다.
    var linearSelected by remember {
        mutableStateOf(true)
    }

    var imageSelected by remember {
        mutableStateOf(true)
    }

    val onLinearClick = { value: Boolean ->
        linearSelected = value
    }

    val onTitleClick = { value: Boolean ->
        imageSelected = value
    }


    ScreenContent(
        linearSelected = linearSelected,
        imageSelected = imageSelected,
        onTitleClick = onTitleClick,
        onLinearClick = onLinearClick,
        titleContent = {
            if (imageSelected) {
                TitleImage(drawing = R.drawable.baseline_cloud_download_24)
            } else {
                Text(
                    "Downloading",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(30.dp)
                )
            }
        },
        progressContent = {
            if (linearSelected) {
                LinearProgressIndicator(Modifier.height(40.dp))
            } else
                CircularProgressIndicator(Modifier.size(200.dp), strokeWidth = 18.dp)
        }
    )
}

//ScreenContent 컴포저블은 화면 콘텐츠를 표시한다.
//화면은 제목, 진행상태 인디케이터, 체크박스를 포함한다.
@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onTitleClick: (Boolean) -> Unit,
    onLinearClick: (Boolean) -> Unit,
    titleContent: @Composable () -> Unit,
    progressContent: @Composable () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        titleContent()
        progressContent()
        CheckBoxes(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onTitleClick = onTitleClick,
            onLinearClick = onLinearClick
        )
    }

}

@Composable
fun TitleImage(drawing: Int) {
    Image(painter = painterResource(id = drawing), contentDescription = "title image")
}

@Composable
fun CheckBoxes(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onTitleClick: (Boolean) -> Unit,
    onLinearClick: (Boolean) -> Unit
) {
    Row(
        Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(checked = imageSelected, onCheckedChange = onTitleClick)
        Text(text = "Image Title")
        Spacer(modifier = Modifier.width(20.dp))
        Checkbox(checked = linearSelected, onCheckedChange = onLinearClick)
        Text(text = "Linear Progress")
    }
}


@Preview(showSystemUi = true)
@Composable
fun DemoPreview() {
    MainScreen()
}


