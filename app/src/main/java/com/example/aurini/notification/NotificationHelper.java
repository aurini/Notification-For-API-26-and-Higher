package com.example.aurini.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.support.annotation.RequiresApi;

@RequiresApi(26)
public class NotificationHelper extends ContextWrapper {

    private  NotificationManager manager;
    public static final String Channel_ID ="com.example.aurini.notification";

    public static final String Channel_Name="notification";

    public NotificationHelper(Context base) {
        super(base);
        createChannel () ;
    }

    private void createChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(Channel_ID, Channel_Name, NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.setLightColor(Color.GREEN);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});


        getManager().createNotificationChannel(notificationChannel);
    }

    public  NotificationManager getManager()
    {
         if(manager == null)
         {
             manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
         }

         return manager;
    }

    @RequiresApi(26)
    public Notification.Builder getNotification (String title, String body)
    {
        return new Notification.Builder(getApplicationContext(), Channel_ID).setContentText(body)
                .setSmallIcon(R.drawable.ic_priority_high_black_24dp)
                .setContentTitle(title).setAutoCancel(true);
    }

}
