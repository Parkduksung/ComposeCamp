package com.example.composebook1.notification

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun NotificationExam(
    modifier: Modifier = Modifier,
    notificationService: CounterNotificationService
) {

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Button(onClick = { notificationService.showNotification(Counter.value) }) {
            Text(text = "Show Notification")
        }
    }
}