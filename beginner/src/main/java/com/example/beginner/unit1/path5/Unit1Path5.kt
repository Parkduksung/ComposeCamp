package com.example.beginner.unit1.path5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beginner.BaseActivity
import com.example.beginner.R

class Unit1Path5 : BaseActivity() {

    @Composable
    override fun InitSetContent(vararg block: @Composable () -> Unit) {

    }

}

@Composable
fun Article() {

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Jetpack Compose tutorial",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            fontSize = 24.sp
        )

        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )

        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewArticle() {
    Article()
}