package com.example.beginner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.beginner.ui.theme.ComposeCampTheme

abstract class BaseActivity : ComponentActivity() {

    @Composable
    protected abstract fun InitSetContent(vararg block: @Composable () -> Unit)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeCampTheme {
                InitSetContent()
            }
        }
    }
}