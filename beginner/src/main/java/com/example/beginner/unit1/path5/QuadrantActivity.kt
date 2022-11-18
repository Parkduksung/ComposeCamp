package com.example.beginner.unit1.path5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beginner.BaseActivity

class QuadrantActivity : BaseActivity() {

    @Composable
    override fun InitSetContent(vararg block: @Composable () -> Unit) {

    }
}

@Composable
fun Quadrant() {

    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.weight(0.5f)) {

            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
                    .background(Color.Green)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Text composable",
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(bottom = 16.dp),
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "Displays text and follows Material Design guidelines.",
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.align(CenterHorizontally),
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
                    .background(Color.Yellow)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Image composable",
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(bottom = 16.dp),
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.align(CenterHorizontally),
                    )
                }
            }

        }
        Row(modifier = Modifier.weight(0.5f)) {

            Box(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
                    .background(Color.Cyan)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Row composable",
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(bottom = 16.dp),
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.align(CenterHorizontally),
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(.5f)
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Column composable",
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(bottom = 16.dp),
                        fontWeight = FontWeight.Bold,

                        )
                    Text(
                        text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.align(CenterHorizontally),
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewQuadrant() {
    Quadrant()
}