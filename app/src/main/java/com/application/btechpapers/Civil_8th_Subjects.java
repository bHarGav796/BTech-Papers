package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class Civil_8th_Subjects extends AppCompatActivity {


    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civil_8th_subjects);
    }




    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }




















    // Civil 8th Sem Subjects OnClick

    public void liveSoon(View v) {
        toastMsg("This Section Will be Live Soon");
    }

    AdView mAdView;


    public void Civil_8_ASD(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_ASD.class);
        startActivity(intent);
    }

    public void Civil_8_BridgeDesign(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_BridgeDesign.class);
        startActivity(intent);
    }

    public void Civil_8_CEM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_CEM.class);
        startActivity(intent);
    }

    public void Civil_8_DOS(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_DOS.class);
        startActivity(intent);
    }

    public void Civil_8_DRM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_DRM.class);
        startActivity(intent);
    }

    public void Civil_8_GT(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_GT.class);
        startActivity(intent);
    }
    public void Civil_8_RSG(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_RSG.class);
        startActivity(intent);
    }

    public void Civil_8_SRM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_8_SRM.class);
        startActivity(intent);
    }



}