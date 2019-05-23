package com.AUStoreHouse;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String tit = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        showNotify(tit,body);
    }

    public void showNotify(String Title,String mess){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "MyNotifications")
                        .setSmallIcon(R.drawable.ere)
                        .setContentTitle(Title)
                        .setContentText(mess)
                        .setAutoCancel(true);
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());

    }
}
