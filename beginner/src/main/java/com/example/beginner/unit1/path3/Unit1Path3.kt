package com.example.beginner.unit1.path3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.beginner.ui.theme.ComposeCampTheme


class Unit1Path3 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithText("Happy Birthday Sam!", "- from Emma")
                }
            }
        }
    }
}


@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column() {
        Text(text = message, fontSize = 36.sp)
        Text(text = from, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithTextPreview() {
    BirthdayGreetingWithText("Happy Birthday Sam!", "- from Emma")
}


@Preview(showSystemUi = true)
@Composable
fun BirthdayGreetingWithTextSystemPreview() {
    BirthdayGreetingWithText("Happy Birthday Sam!", "- from Emma")
}