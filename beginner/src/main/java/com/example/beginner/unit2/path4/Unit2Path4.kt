package com.example.beginner.unit2.path4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.beginner.R
import com.example.beginner.util.Quadruple


class Unit2Path4 : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonApp()
        }
    }
}

@Composable
fun LemonApp() {

    val state = remember { mutableStateOf(LemonAppState()) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LemonTextAndImage(
            step = state.value.currentStep,
            onStepChanged = { state.value = state.value.copy(currentStep = it) },
            squeezeCount = state.value.squeezeCount,
            onSqueezeCountChanged = { state.value = state.value.copy(squeezeCount = it) }
        )
    }
}

data class LemonAppState(var currentStep: Int = 1, var squeezeCount: Int = 0)


@Composable
fun LemonTextAndImage(
    step: Int,
    onStepChanged: (Int) -> Unit,
    squeezeCount: Int,
    onSqueezeCountChanged: (Int) -> Unit
) {

    val (text, image, contentDescription, nextStep) = when (step) {
        1 -> Quadruple(
            R.string.lemon_select,
            R.drawable.lemon_tree,
            R.string.lemon_tree_content_description
        ) {
            onStepChanged(2)
            onSqueezeCountChanged((2..4).random())
        }
        2 -> {
            Quadruple(
                R.string.lemon_squeeze,
                R.drawable.lemon_squeeze,
                R.string.lemon_content_description
            ) {
                if (squeezeCount == 0) {
                    onStepChanged(3)
                } else {
                    onSqueezeCountChanged(squeezeCount - 1)
                }
            }
        }
        3 -> {
            Quadruple(
                R.string.lemon_drink,
                R.drawable.lemon_drink,
                R.string.lemonade_content_description
            ) {
                onStepChanged(4)
            }
        }
        else -> {
            Quadruple(
                R.string.lemon_empty_glass,
                R.drawable.lemon_restart,
                R.string.empty_glass_content_description
            ) {
                onStepChanged(1)
            }
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(text),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = nextStep
                )
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }
}