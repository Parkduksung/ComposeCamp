package com.example.composebook1.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.composebook1.MainActivity
import com.example.composebook1.R

class CounterNotificationService(
    private val context: Context
) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {

        val activityIntent = Intent(context, MainActivity::class.java)

        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationReceiver::class.java),
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )


        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .setContentTitle("Increment Counter")
            .setContentText("The count is $counter")
            .setContentIntent(activityPendingIntent)
            .setDefaults(NotificationCompat.DEFAULT_VIBRATE)
            .addAction(
                R.drawable.baseline_baby_changing_station_24,
                "Increment",
                incrementIntent
            )
            .build()


        notificationManager.notify(1, notification)
    }


    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel_id"
    }
}
