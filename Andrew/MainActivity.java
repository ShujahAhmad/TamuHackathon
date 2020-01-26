package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Random;

import static com.example.notifications.Foodability.CHANNEL_1_ID;
import static com.example.notifications.Foodability.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        /*editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);*/
    }

    public void sendOnChannel1(View view) {
        String title = "Foodability";
        String message = "Recommended restaurant: " + generateRestaurant();

        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0, activityIntent, 0);

        Intent broadcastIntent = new Intent(this, NotificationReceiver.class);
        broadcastIntent.putExtra("toastMessage", message);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.WHITE)
                .setContentIntent(contentIntent)
                //.setAutoCancel(true)
                .setOnlyAlertOnce(false)
                .addAction(R.mipmap.ic_launcher, "View", actionIntent)
                .build();

        notificationManager.notify(1,notification);
    }

    /*public void sendOnChannel2(View view) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2,notification);
    }*/

    public static String generateRestaurant() {
        String restaurant = "";
        Random rand = new Random();
        int n = rand.nextInt(5);

        switch (n) {
            case 0:
                restaurant = "\nMcDonald's - 111 George Bush Dr.";
                break;
            case 1:
                restaurant = "\nTaco Bell - 731 University Dr.";
                break;
            case 2:
                restaurant = "\nChipotle - 815 University Dr.";
                break;
            case 3:
                restaurant = "\nTorchy's - 1037 Texas Ave.";
                break;
            case 4:
                restaurant = "\nFuego's - 108 Poplar St.";
                break;

            default:
                break;
        }

        return  restaurant;
    }
}
