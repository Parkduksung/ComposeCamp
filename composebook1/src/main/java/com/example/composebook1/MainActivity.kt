package com.example.composebook1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.composebook1.notification.CounterNotificationService
import com.example.composebook1.notification.NotificationExam
import com.example.composebook1.ui.theme.ComposeCampTheme

class MainActivity : ComponentActivity() {

    private val notificationService by lazy { CounterNotificationService(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampTheme {
                NotificationExam(modifier = Modifier.fillMaxSize(), notificationService)
            }
        }
    }
}
