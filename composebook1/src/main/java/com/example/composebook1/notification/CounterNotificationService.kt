package com.example.composebook1.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaParser
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.composebook1.MainActivity
import com.example.composebook1.R

class CounterNotificationService(
    private val context: Context
) {

    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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

//        val soundUri = Uri.parse(
//            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.packageName + "/" + R.raw.bell_hb
//        )

//        val audioAttributes =  AudioAttributes.Builder()
//            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//            .build()
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                COUNTER_CHANNEL_ID,
//                "SoundChannel",
//                NotificationManager.IMPORTANCE_DEFAULT
//            ).apply {
//                description = "This is Counter Channel"
//            }
//            notificationManager.createNotificationChannel(channel)
//        }


        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_baby_changing_station_24)
            .setContentTitle("Increment Counter")
            .setContentText("The count is $counter")
            .setContentIntent(activityPendingIntent)
            .setSilent(true)
            .addAction(
                R.drawable.baseline_baby_changing_station_24,
                "Increment",
                incrementIntent
            )
            .setAutoCancel(true)
            .build()

        MediaPlayer.create(context,R.raw.bell_hb).start()

        notificationManager.notify(1, notification)
    }


    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel_id"
    }
}
