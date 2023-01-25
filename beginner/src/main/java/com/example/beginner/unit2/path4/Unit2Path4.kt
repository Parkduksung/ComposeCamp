package com.example.beginner.unit2.path4

import android.os.Bundle
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

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }


    val stepToTextAndImage: (Int) -> Quadruple<Int, Int, Int, () -> Unit> = { step ->
        when (step) {
            1 -> {
                Quadruple(
                    R.string.lemon_select,
                    R.drawable.lemon_tree,
                    R.string.lemon_tree_content_description,
                ) {
                    currentStep = 2
                    squeezeCount = (2..4).random()
                }
            }
            2 -> {
                Quadruple(
                    R.string.lemon_squeeze,
                    R.drawable.lemon_squeeze,
                    R.string.lemon_content_description
                ) {
                    if (squeezeCount == 0) {
                        currentStep = 3
                    } else {
                        squeezeCount--
                    }
                }
            }
            3 -> {
                Quadruple(
                    R.string.lemon_drink,
                    R.drawable.lemon_drink,
                    R.string.lemonade_content_description
                ) {
                    currentStep = 4
                }
            }
            else -> {
                Quadruple(
                    R.string.lemon_empty_glass,
                    R.drawable.lemon_restart,
                    R.string.empty_glass_content_description
                ) {
                    currentStep = 1
                }
            }
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LemonTextAndImage(
            stepToTextAndImage(currentStep)
        )
    }
}

@Composable
fun LemonTextAndImage(
    textAndDrawableAndContentDescription: Quadruple<Int, Int, Int, () -> Unit>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(textAndDrawableAndContentDescription.first),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(textAndDrawableAndContentDescription.second),
            contentDescription = stringResource(textAndDrawableAndContentDescription.third),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = textAndDrawableAndContentDescription.fourth
                )
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }
}