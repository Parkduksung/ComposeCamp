package com.example.composebook1.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.example.composebook1.MainActivity;
import com.example.composebook1.R;

public class SoundNotification {
    
    public void showNotification(Context context){
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getPackageName() + "/" + R.raw.bell_hb);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel("Config.NOTIFICATION_CHANNEL_ID", "Notice", importance);
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            notificationChannel.setSound(soundUri, audioAttributes);
            nm.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, "Config.NOTIFICATION_CHANNEL_ID");
        mBuilder.setSmallIcon(R.drawable.baseline_baby_changing_station_24)
                //.setTicker("Notification.Builder");
                .setWhen(System.currentTimeMillis())
                //.setNumber(10);
                .setContentTitle("Test")
                .setContentText("testMessage")
                .setContentIntent(pendingIntent)
                .setColor(ContextCompat.getColor(context, R.color.teal_200))
                .setAutoCancel(true);


        nm.notify(1, mBuilder.build());
    }
}
