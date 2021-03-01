package com.example.jetpackcompose_experience

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose_experience.ui.theme.Jetpackcompose_experienceTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                MyScreeenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    Jetpackcompose_experienceTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Counter(count:Int, updateCount:(Int)->Unit){
    Button(onClick = { updateCount(count)}) {
        Text("I've been clicked ${count} times")
    }
}

@Composable
fun MyScreeenContent(names: List<String> = listOf("Android","there")) {
    val counterState = remember{
        mutableStateOf(0)
    }

    Column{
        for( name in names){
            Greeting(name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent,thickness = 32.dp)
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}


@Composable
fun Greeting(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!",modifier = Modifier.padding(24.dp))
    }

}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    MyApp{
        MyScreeenContent()
    }
}