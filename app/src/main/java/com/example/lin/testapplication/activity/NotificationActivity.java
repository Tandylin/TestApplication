package com.example.lin.testapplication.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.example.lin.testapplication.R;
import com.example.lin.testapplication.base.BaseActivity;

/**
 * Created by 101912 on 2017/8/9.
 */

public class NotificationActivity extends BaseActivity {


    NotificationManager notificationManager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        button = (Button) findViewById(R.id.bt_notification);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }





    private void sendNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.ic_notification);
        RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.bottom_hint);
        /*builder.setSmallIcon(R.drawable.ic_modify)
                .setLargeIcon(decodeResource)
                .setContentTitle("Notification测试~")
                .setContentText("linziyue hen shuai")
                .setContentInfo("youxiajiao")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setProgress(100, 50, false)
                .setFullScreenIntent(pendingIntent, true);*/
        builder.setContent(remoteView);
        remoteView.setTextViewText(R.id.hint, "lin");
       // Notification notification = builder.build();
       // notification.bigContentView = remoteView;
           //     .setContentIntent(pendingIntent);
        for (int i = 0; i < 2; i ++)
            notificationManager.notify(i, builder.build());
//                .setSmallIcon(R.drawable.ic_notification)
//                .setContentTitle("Notification测试~")
//                .setContentText("linziyue hen shuai");
    }
}
