package com.AUStoreHouse;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity {

    //Added a Comment here Come and check it out


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView syl = findViewById(R.id.syll);
        CardView qps = findViewById(R.id.qps);

        syl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeptAct.class);
                intent.putExtra("key", 0);
                intent.putExtra("Name","Syllabus"); // example
                MainActivity.this.startActivity(intent);
            }
        });

        qps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeptAct.class);
                intent.putExtra("key", 1);
                intent.putExtra("Name","Question Paper"); // example
                MainActivity.this.startActivity(intent);
            }
        });




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("MyNotifications","MyNotifications",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

            FirebaseMessaging.getInstance().subscribeToTopic("general")
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = "Hello There!";
                            if (!task.isSuccessful()) {
                                msg = "Problem Occured";
                            }
                            Log.d("FireBase", msg);
                        }
                    });

        }

    }

    public void binfo(View view){
        Intent i = new Intent(MainActivity.this,InfoAct.class);
        startActivity(i);
    }
}
