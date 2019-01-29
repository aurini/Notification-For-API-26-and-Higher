package com.example.aurini.notification;

import android.app.Notification;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationHelper = new NotificationHelper(this);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
                    try {
                        Notification.Builder builder = notificationHelper.getNotification("my notification", "I can make notification");
                        notificationHelper.getManager().notify(new Random().nextInt(),builder.build() );
                    }
                    catch (Exception e)
                    {
                        Log.e("tag",e.toString() );
                        Toast.makeText(getBaseContext(), "something went wrong", Toast.LENGTH_SHORT).show();
                    }

                }

                else
                {
                    Log.e("tag", "this is for older version less than android api level 26");
                }
            }
        });
    }
}
