package com.application.btechpapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class CivilSyllabusSems extends AppCompatActivity {


    private final static String TAG = "Admob";
    Button Civil2ndSemButton;
    private InterstitialAd mInterstitialAd;

    public void C1S(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil1SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil2ndSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil2SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil3rdSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil3SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil4thSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil4SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil5thSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil5SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil6thSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil6SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil7thSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil7SyllabusWV.class);
        startActivity(intent);
    }

    public void Civil8thSyllabusClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil8SyllabusWV.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civil_syllabus_sems);


        Civil2ndSemButton = findViewById(R.id.Civil2ndSemButton);


        Civil2ndSemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Civil2ndSemButton Clicked");


                if (mInterstitialAd != null) {
                    save_id(Civil2ndSemButton.getId());
                    mInterstitialAd.show(CivilSyllabusSems.this);
                } else {


                    Log.d(TAG, "The Ad was not ready yet");
                    Intent intent = new Intent(CivilSyllabusSems.this, Civil2SyllabusWV.class);
                    startActivity(intent);
                }
            }
        });







    }









    private void save_id(int id) {
        SharedPreferences preferences = getSharedPreferences("SAVING", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("mID", id);
        editor.apply();

    }

    @Override
    protected void onStart() {
        super.onStart();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                AdRequest adRequest = new AdRequest.Builder().build();

                InterstitialAd.load(CivilSyllabusSems.this,"ca-app-pub-5384391241230668/6241317943", adRequest,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                                // The mInterstitialAd reference will be null until
                                // an ad is loaded.
                                mInterstitialAd = interstitialAd;
                                Log.i(TAG, "onAdLoaded");

                                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                                    @Override
                                    public void onAdClicked() {
                                        // Called when a click is recorded for an ad.
                                        Log.d(TAG, "Ad was clicked.");
                                    }

                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when ad is dismissed.
                                        // Set the ad reference to null so you don't show the ad a second time.
                                        Log.d(TAG, "Ad dismissed fullscreen content.");

                                        Intent intent;
                                        switch (load_id()){
                                            case R.id.Civil2ndSemButton:
                                                intent = new Intent(CivilSyllabusSems.this, Civil2SyllabusWV.class);
                                                break;




                                            default:
                                                return;

                                        }

                                        startActivity(intent);
                                        mInterstitialAd = null;
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when ad fails to show.
                                        Log.e(TAG, "Ad failed to show fullscreen content.");
                                        mInterstitialAd = null;
                                    }

                                    @Override
                                    public void onAdImpression() {
                                        // Called when an impression is recorded for an ad.
                                        Log.d(TAG, "Ad recorded an impression.");
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        // Called when ad is shown.
                                        Log.d(TAG, "Ad showed fullscreen content.");
                                    }
                                });

                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                // Handle the error
                                Log.d(TAG, loadAdError.toString());
                                mInterstitialAd = null;
                            }
                        });


            }
        });


    }

    private int load_id() {

        SharedPreferences preferences = getSharedPreferences("SAVING", MODE_PRIVATE);
        return preferences.getInt("mID",0);
    }


}
