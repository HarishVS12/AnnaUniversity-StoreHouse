package com.AUStoreHouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class splashActivity extends AppCompatActivity {
    private ImageView im;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);
        im = findViewById(R.id.imageView2);
        tv = findViewById(R.id.textView);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.anim);
        myanim.setDuration(2200);
        im.startAnimation(myanim);
        Animation textanim = AnimationUtils.loadAnimation(this,R.anim.anim);
        textanim.setDuration(1500);
        tv.startAnimation(textanim);



        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}