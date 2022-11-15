package com.example.beginner.unit1.path4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beginner.BaseActivity
import com.example.beginner.R


class Unit1Path4 : BaseActivity() {

    @Composable
    override fun InitSetContent(vararg block: @Composable () -> Unit) {
        BirthdayGreetingWithImage(
            message = stringResource(id = R.string.happy_birthday_text),
            from = stringResource(id = R.string.signature_text)
        )
    }

}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val paintDrawable = painterResource(id = R.drawable.androidparty)

    Box {
        Image(
            painter = paintDrawable,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        BirthdayGreetingWithText(message, from)
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)

        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewBirthdayGreetingWithImage() {
    BirthdayGreetingWithImage("Happy Birthday Sam!", "- from Emma")
}