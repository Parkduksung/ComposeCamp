package com.example.beginner.unit1.path5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beginner.BaseActivity
import com.example.beginner.R

class TaskManagerActivity : BaseActivity() {

    @Composable
    override fun InitSetContent(vararg block: @Composable () -> Unit) {
        TaskManager(mainText = "All tasks completed", subText = "Nice work!")
    }
}


@Composable
fun TaskManager(mainText: String, subText: String) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.align(Alignment.Center)) {

            Image(
                painter = painterResource(id = R.drawable.ic_task_completed),
                contentDescription = null,
            )

            Text(
                text = mainText,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 24.dp, bottom = 8.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subText,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTaskManager() {
    TaskManager(mainText = "All tasks completed", subText = "Nice work!")
}