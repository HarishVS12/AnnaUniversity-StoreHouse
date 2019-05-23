package com.AUStoreHouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class DeptAct extends AppCompatActivity {
    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);

        MobileAds.initialize(this,"ca-app-pub-5040215542785098~4205978715");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        int key = getIntent().getIntExtra("key", -1);
        CardView cse;
        CardView ece;
        CardView eee;
        CardView civ;
        CardView mec;

        if (key == 0) {
            //Syllabus

            cse = findViewById(R.id.cse);
            ece = findViewById(R.id.ece);
            eee = findViewById(R.id.eee);
            civ = findViewById(R.id.civil);
            mec = findViewById(R.id.mech);

            cse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DeptAct.this, SemAct.class);
                    i.putExtra("key", 20);
                    startActivity(i);
                }
            });
            ece.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DeptAct.this, SemAct.class);
                    i.putExtra("key", 21);
                    startActivity(i);
                }
            });
            eee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DeptAct.this, SemAct.class);
                    i.putExtra("key", 22);
                    startActivity(i);
                }
            });
            civ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DeptAct.this, SemAct.class);
                    i.putExtra("key", 23);
                    startActivity(i);
                }
            });
            mec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(DeptAct.this, SemAct.class);
                    i.putExtra("key", 24);
                    startActivity(i);
                }
            });
        }
            if (key == 1) {
            //Question Papers


                cse = findViewById(R.id.cse);
                ece = findViewById(R.id.ece);
                eee = findViewById(R.id.eee);
                civ = findViewById(R.id.civil);
                mec = findViewById(R.id.mech);


                cse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DeptAct.this, SemAct.class);
                        i.putExtra("key", 10);
                        startActivity(i);
                    }
                });

                ece.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DeptAct.this, SemAct.class);
                        i.putExtra("key", 11);
                        startActivity(i);
                    }
                });
                eee.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DeptAct.this, SemAct.class);
                        i.putExtra("key", 12);
                        startActivity(i);
                    }
                });
                civ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DeptAct.this, SemAct.class);
                        i.putExtra("key", 13);
                        startActivity(i);
                    }
                });
                mec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(DeptAct.this, SemAct.class);
                        i.putExtra("key", 14);
                        startActivity(i);
                    }
                });

            }


    }
}
