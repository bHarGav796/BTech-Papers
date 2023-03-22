package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

public class Premium_Class_Notes extends AppCompatActivity {

    AdView adView;

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }


    public void liveSoon(View v) {
        toastMsg("This Section Will be Live Soon");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.premium_class_notes);

        adView=findViewById(R.id.adView);

//        Admob Banner Ads
//        Step 1

        MobileAds.initialize(this);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);


    }

    public void CSE_Premium(View v) {
        Intent intent = new Intent(getApplicationContext(), PREMIUM_CSE_SEMS.class);
        startActivity(intent);
    }
}


