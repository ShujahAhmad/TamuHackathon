package com.example.notifications;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Foodability extends Application {
    public static final String CHANNEL_1_ID = "Foodability";
    public static final String CHANNEL_2_ID = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Foodability",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("Recommended restaurant nearby!");

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Foodability",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("Good Accomodations!");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
