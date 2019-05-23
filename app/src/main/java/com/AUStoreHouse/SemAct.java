package com.AUStoreHouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class SemAct extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem);
        MobileAds.initialize(this,"ca-app-pub-5040215542785098~4205978715");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5040215542785098/7772471017");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        CardView sem1 = findViewById(R.id.sem1);
        CardView sem2 = findViewById(R.id.sem2);
        CardView sem3 = findViewById(R.id.sem3);
        CardView sem4 = findViewById(R.id.sem4);
        int key = getIntent().getIntExtra("key", -1);

        switch (key){

            //CSE
            case 20:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(12);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(13);
                    }
                });
               sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                   public void onClick(View v) {
                       nextAct(14);
                   }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(990);
                    }
                });
                break;
            case 10:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(02);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(03);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //04
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //04
                    }
                });

                break;

                //**********************************************************************************
                //ECE

            case 21:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(15);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(16);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(17);
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(991);
                    }
                });
                break;

            case 11:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(5);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(6);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //7
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //04
                    }
                });
                break;

            //**********************************************************************************
            //EEE

            case 22:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(18);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(19);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(20);
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(992);
                    }
                });
                break;

            case 12:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(8);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(9);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //10
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //04
                    }
                });
                break;

                //**********************************************************************
            //CIVIL

            case 23:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(21);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(22);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(23);
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(993);
                    }
                });
                break;

            case 13:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(11);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(120);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //130
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //04
                    }
                });
                break;

            //**********************************************************************
            //MECH

            case 24:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(25);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(26);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(27);
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(994);
                    }
                });
                break;

            case 14:
                sem1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(150);
                    }
                });
                sem2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextAct(160);
                    }
                });
                sem3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //170
                    }
                });
                sem4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SemAct.this,"Coming Soon!",Toast.LENGTH_LONG).show(); //04
                    }
                });
                break;
        }


    }

    public void nextAct(final int key){
        if(interstitialAd.isLoaded()){
            interstitialAd.show();
        }else{
            final Intent i = new Intent(SemAct.this,DataFetchActivity.class);
            i.putExtra("key",key);
            startActivity(i);

        }
        interstitialAd.setAdListener(new AdListener()
                                     {
            @Override
            public void onAdClosed() {
                final Intent i = new Intent(SemAct.this,DataFetchActivity.class);
                i.putExtra("key",key);
                startActivity(i);
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        }
        );
    }

    @Override
    public void onBackPressed() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        }else{
            super.onBackPressed();
        }
    }

}
