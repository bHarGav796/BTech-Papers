package com.application.btechpapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.messaging.FirebaseMessaging;

import eu.dkaratzas.android.inapp.update.Constants;
import eu.dkaratzas.android.inapp.update.InAppUpdateManager;
import eu.dkaratzas.android.inapp.update.InAppUpdateStatus;



public class MainActivity<progressBar> extends AppCompatActivity implements InAppUpdateManager.InAppUpdateHandler {



//    New Interstitial For Multiple Buttons
    private final static String TAG = "Admob";
    RelativeLayout SyllabusClick, showInter;




    InAppUpdateManager inAppUpdateManager;
//    RelativeLayout showInter;


    private InterstitialAd mInterstitialAd;




    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }



//    public void studymaterials(View v) {
//        toastMsg("Study Materials Will be Live Soon");
//    }

    //    public void placement(View v) {
//        toastMsg("Study Materials Will be Live Soon");
//    }


    public void liveSoon(View v) {
        toastMsg("This Section Will be Live Soon");
    }



    AdView mAdView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        SyllabusClick = findViewById(R.id.SyllabusClick);
        showInter = findViewById(R.id.showInter);


        SyllabusClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Syllabus Clicked");


                if (mInterstitialAd != null) {
                    save_id(SyllabusClick.getId());
                    mInterstitialAd.show(MainActivity.this);
                } else {


                    Log.d(TAG, "The Ad was not ready yet");
                    Intent intent = new Intent(MainActivity.this, syllabus2.class);
                    startActivity(intent);
                }
            }
        });




        showInter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Syllabus Clicked");
                if (mInterstitialAd != null) {
                    save_id(showInter.getId());
                    mInterstitialAd.show(MainActivity.this);
                } else {
                    Log.d(TAG, "The Ad was not ready yet");
                    Intent intent = new Intent(MainActivity.this, Premium_Class_Notes.class);
                    startActivity(intent);
                }
            }
        });








//        Update test
        //update ke liye coding
        inAppUpdateManager =InAppUpdateManager.Builder(this,101)
                .resumeUpdates(true)
                .mode(Constants.UpdateMode.IMMEDIATE)
                .snackBarAction("An update has just been downloaded")
                .snackBarAction("RESTART")
                .handler(this);
        inAppUpdateManager.checkForAppUpdate();





//        Admob Ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Step 1
        mAdView = findViewById(R.id.adView);

        // Step 2
        AdRequest adRequest = new AdRequest.Builder().build();

        // Step 3
        mAdView.loadAd(adRequest);









//        FIREBASE
        FirebaseMessaging.getInstance().subscribeToTopic("notification");


    }

    private void save_id(int id) {
        SharedPreferences preferences = getSharedPreferences("SAVING", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("mID", id);
        editor.apply();
    }

    private int load_id(){
        SharedPreferences preferences = getSharedPreferences("SAVING", MODE_PRIVATE);
         return preferences.getInt("mID",0);
    }


//



//Syllabus













    //BRANCHES

    public void Internal (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Colleges());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void engbranches (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Branches());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //    Mechanical Engineering Sem
    public void mechanicalclick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new MechanicalSems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
//Electrical Engineering Sem

    public void electricalclick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ElectricalSems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Civil Engineering Sem

    public void civilclick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CivilSems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Electronics Engineering Sem

    public void ETCclick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ElectronicsSems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //Electronics Engineering Sem

    public void CSEClick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSESems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//Chemical Engineering Sem

    public void chemicalclick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ChemicalSems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //Instrumentation Engineering Sem

    public void Instruclick (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new InstrumentationSems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void mecha1sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mecha1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Mecha2Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mecha2Subs());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Mecha3Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mecha3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Mecha4Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mechanical4_subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void Mecha5Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mechanical5_Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Mecha6Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mechanical6_Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Mecha7Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mechanical7_Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Mecha8Subs (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Mechanical8_Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



//ELECTRICAL ENGINEERING SEMS

    public void electrical1sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void electrical2sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical2Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void electrical3sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void electrical4sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical4Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void electrical5sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical5Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void electrical6sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical6Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void electrical7sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical7Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void electrical8sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Electrical8Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//CIVIL ENGINEERING SEMS

    public void civil1sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void civil2sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil2Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void civil3sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void civil4sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil4Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //
    public void civil5sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil5Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void civil6sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil6Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }






    public void civil7sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil7Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void civil8sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Civil8Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    //ELECTRONICS ENGINEERING SEMS

    public void ETC1sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void ETC2sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC2Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //
    public void ETC3sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //
    public void ETC4sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC4Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //    //
    public void ETC5sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC5Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //    //
    public void ETC6sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC6Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //    //
    public void ETC7sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC7Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void ETC8sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new ETC8Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //COMPUTER ENGINEERING SEMS

    public void CSE1sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE2sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE2Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE3sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE4sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE4Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE5sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE5Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE6sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE6Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE7sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE7Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void CSE8sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new CSE8Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    //CHEMICAL ENGINEERING SEMS

    public void Chem1sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem2sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem2Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem3sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem4sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem4Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem5sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem5Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem6sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem6Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem7sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem7Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Chem8sub (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Chem8Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


//    Chemical Engineering 7th Sem Subjects OnClick

    public void Chem_7_PED(View v) {
        Intent intent = new Intent(getApplicationContext(), Chem_7_PED.class);
        startActivity(intent);
    }

    public void Chem_7_PSE(View v) {
        Intent intent = new Intent(getApplicationContext(), Chem_7_PSE.class);
        startActivity(intent);
    }

    public void Chem_7_NM(View v) {
        Intent intent = new Intent(getApplicationContext(), Chem_7_NM.class);
        startActivity(intent);
    }

    public void Chem_7_POM(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_7_POM.class);
        startActivity(intent);
    }


//INSTRUMENTATION ENGINEERING SEMS

    public void Instru1Sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru1Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Instru2Sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru2Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Instru3Sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru3Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Instru4Sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru4Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void Instru5Sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru5Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Instru6Sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru6Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Instru7sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru7Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void Instru8sem (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new Instru8Subjects());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




//    public void studymaterials(View v) {
//        Intent intent = new Intent(getApplicationContext(), Premium_Class_Notes.class);
//        startActivity(intent);
//    }









//    Main Activity Clicks

    public void about_us(View v) {
        Intent intent = new Intent(getApplicationContext(), AboutUss.class);
        startActivity(intent);
    }



//    public void SyllabusOnClick(View v) {
//        Intent intent = new Intent(getApplicationContext(), syllabus2.class);
//        startActivity(intent);
//    }



        public void placementOnClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Placement_Prep.class);
        startActivity(intent);
    }



    public void Notice(View v) {
        Intent intent = new Intent(getApplicationContext(), NoticeBoard.class);
        startActivity(intent);
    }
    public void Result(View v) {
        Intent intent = new Intent(getApplicationContext(), Results.class);
        startActivity(intent);
    }



//    CSE 1st Sem Subjects OnClick

    public void CSE_1_Phy(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_1_Phy.class);
        startActivity(intent);
    }
    public void CSE_1_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_1_Maths.class);
        startActivity(intent);
    }
    public void CSE_1_EG(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_1_EG.class);
        startActivity(intent);
    }
    public void CSE_1_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_1_EM.class);
        startActivity(intent);
    }
    public void CSE_1_SOCIOLOGY(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_1_SOCIOLOGY.class);
        startActivity(intent);
    }

    //    CSE 2nd Sem Subjects OnClick

    public void CSE_2_Chem(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_2_Chem.class);
        startActivity(intent);
    }
    public void CSE_2_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_2_Maths.class);
        startActivity(intent);
    }
    public void CSE_2_PSTC(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_2_PSTC.class);
        startActivity(intent);
    }
    public void CSE_2_BEE(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_2_BEE.class);
        startActivity(intent);
    }
    public void CSE_2_CPS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_2_CPS.class);
        startActivity(intent);
    }

    //    CSE 3rd Sem Subjects OnClicks

    public void CSE3Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_3_Maths.class);
        startActivity(intent);
    }
    public void CSE3Oops(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_3_Oops.class);
        startActivity(intent);
    }
    public void CSE_3_DS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_3_DS.class);
        startActivity(intent);
    }
    public void CSE_3_DSA(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_3_DSA.class);
        startActivity(intent);
    }
    public void CSE_3_BSS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_3_BSS.class);
        startActivity(intent);
    }
    public void CSE_3_COI(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_3_COI.class);
        startActivity(intent);
    }

//    CSE 4th Sem Subjects OnClicks

    public void CSE_4_DM(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_4_DM.class);
        startActivity(intent);
    }
    public void CSE_4_CAO(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_4_CAO.class);
        startActivity(intent);
    }
    public void CSE_4_OS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_4_OS.class);
        startActivity(intent);
    }
    public void CSE_4_JP(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_4_JP.class);
        startActivity(intent);
    }
    public void CSE_4_GT(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_4_GT.class);
        startActivity(intent);
    }
    public void CSE_4_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_4_ES.class);
        startActivity(intent);
    }

//    CSE 5th Sem Subjects OnClicks

    public void CSE_5_DBMS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_5_DBMS.class);
        startActivity(intent);
    }
    public void CSE_5_CG(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_5_CG.class);
        startActivity(intent);
    }
    public void CSE_5_DAA(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_5_DAA.class);
        startActivity(intent);
    }
    public void CSE_5_EOC(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_5_ECO.class);
        startActivity(intent);
    }
    public void CSE_5_FLAT(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_5_FLAT.class);
        startActivity(intent);
    }
    public void CSE_5_MC(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_5_MC.class);
        startActivity(intent);
    }

//CSE 6th Sem Subjects OnClicks

    public void CSE_6_CD(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_6_CD.class);
        startActivity(intent);
    }
    public void CSE_6_IP(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_6_IP.class);
        startActivity(intent);
    }
    public void CSE_6_SE(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_6_SE.class);
        startActivity(intent);
    }
    public void CSE_6_DM(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_6_DM.class);
        startActivity(intent);
    }
    public void CSE_6_CN(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_6_CN.class);
        startActivity(intent);
    }
    public void CSE_6_ACCN(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_6_ACCN.class);
        startActivity(intent);
    }

//CSE 7th Sem Subjects OnClicks

    public void CSE_7_POM(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_7_POM.class);
        startActivity(intent);
    }
    public void CSE_7_ML(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_7_ML.class);
        startActivity(intent);
    }
    public void CSE_7_DS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_7_DS.class);
        startActivity(intent);
    }

    public void CSE_7_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_7_ES.class);
        startActivity(intent);
    }
    public void CSE_7_CC(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_7_CC.class);
        startActivity(intent);
    }



//CSE 8th Sem Subjects OnClicks

    public void CSE_8_CNS(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_8_CNS.class);
        startActivity(intent);
    }
    public void CSE_8_AI(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_8_AI.class);
        startActivity(intent);
    }
    public void CSE_8_IOT(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_8_IOT.class);
        startActivity(intent);
    }

    public void CSE_8_NLP(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_8_NLP.class);
        startActivity(intent);
    }
    public void CSE_8_NNL(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE_8_NNL.class);
        startActivity(intent);
    }




















//Mechanical Engineering Subjects OnClick

    //Mechanical 1st Sem Subjects OnClick

    public void Mech_1_BEE(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_1_BEE.class);
        startActivity(intent);
    }

    public void Mech_1_Chem(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_1_Chem.class);
        startActivity(intent);
    }

    public void Mech_1_CPS(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_1_CPS.class);
        startActivity(intent);
    }

    public void Mech_1_PSPC(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_1_PSPC.class);
        startActivity(intent);
    }

    public void Mech_1_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_1_Maths.class);
        startActivity(intent);
    }

    //    Mechanical 2nd Sem Subjects OnClick

    public void Mech_2_PHY(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_2_PHY.class);
        startActivity(intent);
    }

    public void Mech_2_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_2_Maths.class);
        startActivity(intent);
    }

    public void Mech_2_Graphics(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_2_Graphics.class);
        startActivity(intent);
    }

    public void Mech_2_Mechanics(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_2_Mechanics.class);
        startActivity(intent);
    }

    public void Mech_2_Sociology(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_2_Sociology.class);
        startActivity(intent);
    }

    //    Mechanical 3rd Sem Subjects OnClick

    public void Mech_3_MAD(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_3_MAD.class);
        startActivity(intent);
    }

    public void Mech_3_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_3_Maths.class);
        startActivity(intent);
    }

    public void Mech_3_ET(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_3_ET.class);
        startActivity(intent);
    }

    public void Mech_3_BT(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_3_BT.class);
        startActivity(intent);
    }

    public void Mech_3_TOM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_3_TOM.class);
        startActivity(intent);
    }

    public void Mech_3_COI(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_3_COI.class);
        startActivity(intent);
    }

    //    Mechanical 4th Sem Subjects OnClick

    public void Mech_4_AE(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_4_AE.class);
        startActivity(intent);
    }

    public void Mech_4_WP(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_4_WP.class);
        startActivity(intent);
    }

    public void Mech_4_FM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_4_FM.class);
        startActivity(intent);
    }

    public void Mech_4_MS(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_4_MS.class);
        startActivity(intent);
    }

    public void Mech_4_MM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_4_MM.class);
        startActivity(intent);
    }

    public void Mech_4_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_4_ES.class);
        startActivity(intent);
    }

    //    Mechanical 5th Sem Subjects OnClick

    public void Mech_5_AT(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_5_AT.class);
        startActivity(intent);
    }

    public void Mech_5_MD(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_5_MD.class);
        startActivity(intent);
    }

    public void Mech_5_MDM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_5_MDM.class);
        startActivity(intent);
    }

    public void Mech_5_HT(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_5_HT.class);
        startActivity(intent);
    }

    public void Mech_5_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_5_EM.class);
        startActivity(intent);
    }

    public void Mech_5_EE(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_5_EE.class);
        startActivity(intent);
    }

    //    Mechanical 6th Sem Subjects OnClick

    public void Mech_6_MD(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_6_MD.class);
        startActivity(intent);
    }

    public void Mech_6_FM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_6_FM.class);
        startActivity(intent);
    }

    public void Mech_6_MMI(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_6_MMI.class);
        startActivity(intent);
    }

    public void Mech_6_WP(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_6_WP.class);
        startActivity(intent);
    }

    public void Mech_6_HT(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_6_HT.class);
        startActivity(intent);
    }

    public void Mech_6_ACCN(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_6_ACCN.class);
        startActivity(intent);
    }

    //    Mechanical 7th Sem Subjects OnClick

    public void Mech_7_VMS(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_7_VMS.class);
        startActivity(intent);
    }

    public void Mech_7_AT(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_7_AT.class);
        startActivity(intent);
    }

    public void Mech_7_IEM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_7_IEM.class);
        startActivity(intent);
    }

    public void MECH_7_HM(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_HM.class);
        startActivity(intent);
    }

    public void MECH_7_RES(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_RES.class);
        startActivity(intent);
    }


    public void MECH_7_Refrigiration(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_Refrigiration.class);
        startActivity(intent);
    }


    public void MECH_7_OR(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_OR.class);
        startActivity(intent);
    }





    public void MECH_7_PPT(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_PPT.class);
        startActivity(intent);
    }

    public void MECH_7_SWM(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_SWM.class);
        startActivity(intent);
    }

    public void MECH_7_MachineTools(View v) {
        Intent intent = new Intent(getApplicationContext(), MECH_7_MachineTools.class);
        startActivity(intent);
    }



    public void Mech_7_POM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_7_POM.class);
        startActivity(intent);
    }

// Mechanical Engineering 8th Sem

    public void Mech_8_MM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_8_MM.class);
        startActivity(intent);
    }

    public void Mech_8_AC(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_8_AC.class);
        startActivity(intent);
    }

    public void Mech_8_AM(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_8_AM.class);
        startActivity(intent);
    }

    public void Mech_8_ICE(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_8_ICE.class);
        startActivity(intent);
    }

    public void Mech_8_Mechatronics(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_8_Mechatronics.class);
        startActivity(intent);
    }

    public void Mech_8_NVC(View v) {
        Intent intent = new Intent(getApplicationContext(), Mech_8_NVC.class);
        startActivity(intent);
    }








// Mechanical Engineering 8th Sem Left
// Mechanical Engineering 8th Sem Left


//Civil 1st Sem Subjects OnClick

    public void Civil_1_Chem(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_1_Chem.class);
        startActivity(intent);
    }

    public void Civil_1_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_1_Maths.class);
        startActivity(intent);
    }

    public void Civil_1_PSPC(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_1_PSPC.class);
        startActivity(intent);
    }

    public void Civil_1_BEE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_1_BEE.class);
        startActivity(intent);
    }

    public void Civil_1_CPS(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_1_CPS.class);
        startActivity(intent);
    }


// Civil 2nd Sem Subjects OnClick

    public void Civil_2_PHY(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_2_PHY.class);
        startActivity(intent);
    }

    public void Civil_2_MATHS(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_2_MATHS.class);
        startActivity(intent);
    }

    public void Civil_2_EG(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_2_EG.class);
        startActivity(intent);
    }

    public void Civil_2_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_2_EM.class);
        startActivity(intent);
    }

    public void Civil_2_Sociology(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_2_Sociology.class);
        startActivity(intent);
    }

// Civil 3rd Sem Subjects OnClick

    public void Civil_3_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_3_Maths.class);
        startActivity(intent);
    }

    public void Civil_3_SM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_3_SM.class);
        startActivity(intent);
    }

    public void Civil_3_FM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_3_FM.class);
        startActivity(intent);
    }

    public void Civil_3_BCP(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_3_BCP.class);
        startActivity(intent);
    }

    public void Civil_3_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_3_ES.class);
        startActivity(intent);
    }

    public void Civil_3_SA(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_3_SA.class);
        startActivity(intent);
    }

// Civil 4th Sem Subjects OnClick

    public void Civil_4_HHM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_4_HHM.class);
        startActivity(intent);
    }

    public void Civil_4_SA(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_4_SA.class);
        startActivity(intent);
    }

    public void Civil_4_ES2(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_4_ES2.class);
        startActivity(intent);
    }

    public void Civil_4_EG(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_4_EG.class);
        startActivity(intent);
    }

    public void Civil_4_CMCT(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_4_CMCT.class);
        startActivity(intent);
    }

    public void Civil_4_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_4_ES.class);
        startActivity(intent);
    }

    // Civil 5th Sem Subjects OnClick

    public void Civil_5_OCF(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_5_OCF.class);
        startActivity(intent);
    }

    public void Civil_5_SD1(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_5_SD1.class);
        startActivity(intent);
    }

    public void Civil_5_EE1(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_5_EE1.class);
        startActivity(intent);
    }

    public void Civil_5_TE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_5_TE.class);
        startActivity(intent);
    }

    public void Civil_5_GE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_5_GE.class);
        startActivity(intent);
    }

    public void Civil_5_EE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_5_EE.class);
        startActivity(intent);
    }

    // Civil 6th Sem Subjects OnClick

    public void Civil_6_TE2(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_6_TE2.class);
        startActivity(intent);
    }

    public void Civil_6_EH(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_6_EH.class);
        startActivity(intent);
    }

    public void Civil_6_SD(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_6_SD.class);
        startActivity(intent);
    }

    public void Civil_6_EE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_6_EE.class);
        startActivity(intent);
    }

    public void Civil_6_GE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_6_GE.class);
        startActivity(intent);
    }

    public void Civil_6_ACCN(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_6_ACCN.class);
        startActivity(intent);
    }

    // Civil 7th Sem Subjects OnClick

    public void Civil_7_QS(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_7_QS.class);
        startActivity(intent);
    }

    public void Civil_7_POM(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_7_POM.class);
        startActivity(intent);
    }

    public void Civil_7_EIA(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_7_EIA.class);
        startActivity(intent);
    }

    public void Civil_7_GIT(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_7_GIT.class);
        startActivity(intent);
    }

    public void Civil_7_WRE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_7_WRE.class);
        startActivity(intent);
    }

    public void Civil_7_RE(View v) {
        Intent intent = new Intent(getApplicationContext(), Civil_7_RE.class);
        startActivity(intent);
    }









    // Civil 8th Sem Subjects OnClick

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














//    ELECTRICAL 1st Sem Subjects OnClick

    public void Electrical_1_Phy(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_1_Phy.class);
        startActivity(intent);
    }
    public void Electrical_1_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_1_Maths.class);
        startActivity(intent);
    }
    public void Electrical_1_EG(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_1_EG.class);
        startActivity(intent);
    }
    public void Electrical_1_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_1_EM.class);
        startActivity(intent);
    }
    public void Electrical_1_SOCIOLOGY(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_1_SOCIOLOGY.class);
        startActivity(intent);
    }



// Electrical 2nd Sem Subjects OnClick

    public void Electrical_2_Chemistry(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_2_Chemistry.class);
        startActivity(intent);
    }

    public void Electrical_2_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_2_Maths.class);
        startActivity(intent);
    }

    public void Electrical_2_PSTC(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_2_PSTC.class);
        startActivity(intent);
    }

    public void Electrical_2_BEE(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_2_BEE.class);
        startActivity(intent);
    }

    public void Electrical_2_CPS(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_2_CPS.class);
        startActivity(intent);
    }

// Electrical 3rd Sem Subjects OnClick

    public void Electrical_3_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_3_Maths.class);
        startActivity(intent);
    }

    public void Electrical_3_ECA(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_3_ECA.class);
        startActivity(intent);
    }

    public void Electrical_3_AE(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_3_AE.class);
        startActivity(intent);
    }

    public void Electrical_3_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_3_EM.class);
        startActivity(intent);
    }

    public void Electrical_3_DE(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_3_DE.class);
        startActivity(intent);
    }

    public void Electrical_3_COI(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_3_COI.class);
        startActivity(intent);
    }


// Electrical 4th Sem Subjects OnClick

    public void Electrical_4_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_4_EM.class);
        startActivity(intent);
    }

    public void Electrical_4_CS(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_4_CS.class);
        startActivity(intent);
    }

    public void Electrical_4_EM2(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_4_EM2.class);
        startActivity(intent);
    }

    public void Electrical_4_PS(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_4_PS.class);
        startActivity(intent);
    }

    public void Electrical_4_SS(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_4_SS.class);
        startActivity(intent);
    }

    public void Electrical_4_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_4_ES.class);
        startActivity(intent);
    }




// Electrical 5th Sem Subjects OnClick

    public void Electrical_5_PS2(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_PS2.class);
        startActivity(intent);
    }

    public void Electrical_5_PE(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_PE.class);
        startActivity(intent);
    }

    public void Electrical_5_MP(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_MP.class);
        startActivity(intent);
    }

    public void Electrical_5_CONM(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_CONM.class);
        startActivity(intent);
    }

    public void Electrical_5_DSAB(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_DSAB.class);
        startActivity(intent);
    }

    public void Electrical_5_ACS(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_ACS.class);
        startActivity(intent);
    }

    public void Electrical_5_AEM(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_AEM.class);
        startActivity(intent);
    }

    public void Electrical_5_EE(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_5_EE.class);
        startActivity(intent);
    }

//    public void Electrical_5_EE(View v) {
//        Intent intent = new Intent(getApplicationContext(), Electrical_5_EE.class);
//        startActivity(intent);
//    }


// Electrical 6th Sem Subjects OnClick

    public void Electrical_6_PS(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_6_PS.class);
        startActivity(intent);
    }

    public void Electrical_6_ED(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_6_ED.class);
        startActivity(intent);
    }

    public void Electrical_6_EFT(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_6_EFT.class);
        startActivity(intent);
    }

    public void Electrical_6_ACCN(View v) {
        Intent intent = new Intent(getApplicationContext(), Electrical_6_ACCN.class);
        startActivity(intent);
    }

//    ELectrical 7th Sem OnClick

    public void ELEC_7_PowerSystemIV(View v) {
        Intent intent = new Intent(getApplicationContext(), ELEC_7_PowerSystemIV.class);
        startActivity(intent);
    }

    public void ELEC_7_HVE(View v) {
        Intent intent = new Intent(getApplicationContext(), ELEC_7_HVE.class);
        startActivity(intent);
    }


    public void ELEC_7_RES(View v) {
        Intent intent = new Intent(getApplicationContext(), ELEC_7_RES.class);
        startActivity(intent);
    }


    public void ELEC_7_EHV(View v) {
        Intent intent = new Intent(getApplicationContext(), ELEC_7_EHV.class);
        startActivity(intent);
    }






//    Electronics 3rd Sem

    public void ETC_sub1_Maths(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_3_Maths.class);
        startActivity(intent);
    }


    public void ETC_sub1_Semiconductors(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_sub1_Semiconductors.class);
        startActivity(intent);
    }

    public void ETC_sub1_DigitalCircuits(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_sub1_DigitalCircuits.class);
        startActivity(intent);
    }

    public void ETC_sub1_NetworkTheory(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_sub1_NetworkTheory.class);
        startActivity(intent);
    }

    public void ETC_sub1_SignalSystem(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_sub1_SignalSystem.class);
        startActivity(intent);
    }

    public void ETC_sub1_COI(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_sub1_COI.class);
        startActivity(intent);
    }

//ELECTRONICS 5th SEM


    public void ETC_5_MP(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_5_MP.class);
        startActivity(intent);
    }

    public void ETC_5_DSA(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_5_DSA.class);
        startActivity(intent);
    }

    public void ETC_5_DC(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_5_DC.class);
        startActivity(intent);
    }

    public void ETC_5_CS(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_5_CS.class);
        startActivity(intent);
    }

    public void ETC_5_CN(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_5_CN.class);
        startActivity(intent);
    }

    public void ETC_5_EE(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_5_EE.class);
        startActivity(intent);
    }









//ELECTRONICS 7th SEM


    public void ETC_7_ME(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_7_ME.class);
        startActivity(intent);
    }

    public void ETC_7_VLSI(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_7_VLSI.class);
        startActivity(intent);
    }

    public void ETC_7_IP(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_7_IP.class);
        startActivity(intent);
    }

    public void ETC_7_ITC(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_7_ITC.class);
        startActivity(intent);
    }

    public void ETC_7_NE(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC_7_NE.class);
        startActivity(intent);
    }










//    INSTRU 3rd Sem Subjects OnClicks

    public void Instru3ECA(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru3ECA.class);
        startActivity(intent);
    }
    public void Instru3AE(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru3AE.class);
        startActivity(intent);
    }
    public void Instru3Transuders(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru3Transuders.class);
        startActivity(intent);
    }
    public void Instru3DE(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru3DE.class);
        startActivity(intent);
    }

//    Instru 4th Sem Subjects OnClicks

    public void Instru_4_EM(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_4_EM.class);
        startActivity(intent);
    }
    public void Instru_4_CS(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_4_CS.class);
        startActivity(intent);
    }
    public void Instru_4_II(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_4_II.class);
        startActivity(intent);
    }
    public void Instru_4_EMachine(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_4_EMachine.class);
        startActivity(intent);
    }
    public void Instru_4_SS(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_4_SS.class);
        startActivity(intent);
    }
    public void Instru_4_ES(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_4_ES.class);
        startActivity(intent);
    }




//    Instru 5th Sem Subjects OnClicks

    public void Instru_5_PC(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_5_PC.class);
        startActivity(intent);
    }
    public void Instru_5_OOPS(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_5_OOPS.class);
        startActivity(intent);
    }
    public void Instru_5_MP(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_5_MP.class);
        startActivity(intent);
    }
    public void Instru_5_EE(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_5_EE.class);
        startActivity(intent);
    }


//    8th Sem Instru OnClick

    public void Instru_8_PPI(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_8_PPI.class);
        startActivity(intent);
    }

    public void Instru_8_SSSP(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_8_SSSP.class);
        startActivity(intent);
    }


    public void Instru_8_VHDL(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_8_VHDL.class);
        startActivity(intent);
    }


    public void Instru_8_EI(View v) {
        Intent intent = new Intent(getApplicationContext(), Instru_8_EI.class);
        startActivity(intent);
    }




    //CIE

    //AEC SEMS

    public void AEC_SEMS (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new AEC_Sems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //AEC COLLEGE BRANCHES
    public void AEC_Branches (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new AEC_College_Branches());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }








    //AEC CSE CIE SEMS
    public void AEC_CSE_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new AEC_CSE_CIE_Sems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    //    public void AEC_CSE_CIE_1st_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_1st_SEM.class);
//        startActivity(intent);
//    }
//    public void AEC_CSE_CIE_2nd_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_2nd_SEM.class);
//        startActivity(intent);
//    }
//    public void AEC_CSE_CIE_3rd_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_3rd_SEM.class);
//        startActivity(intent);
//    }
//    public void AEC_CSE_CIE_4th_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_4th_SEM.class);
//        startActivity(intent);
//    }
//    public void AEC_CSE_CIE_5th_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_5th_SEM.class);
//        startActivity(intent);
//    }
    public void AEC_CIE_6th_SEM(View v) {
        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_6.class);
        startActivity(intent);
    }
//    public void AEC_CSE_CIE_7th_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_7th_SEM.class);
//        startActivity(intent);
//    }
//
//    public void AEC_CSE_CIE_8th_SEM(View v) {
//        Intent intent = new Intent(getApplicationContext(), AEC_CSE_CIE_8th_SEM.class);
//        startActivity(intent);
//    }







    //JEC SEMS
    public void JEC_Branches (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new JEC_College_Branches());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    //JEC CIE SEMS
    public void JEC_CSE_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new JEC_SEMS());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void JEC_Civil_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new JEC_Civil_Sems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void JEC_Mechanical_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new JEC_Mechanical_Sems());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void JEC_Electrical_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new JEC_Electrical_CIE());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    public void JEC_Instru_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new JEC_Instru_CIE());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }




    //GIMT SEMS
    public void GIMT_Branches (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new GIMT_College_Branches());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    //GIMT CIE SEMS
    public void GIMT_CSE_CIE (View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContent, new GIMT_CSE_SEMS());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

//  CSE CIE's

    public void GIMT_CSE_1_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_1_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_2_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_2_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_3_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_3_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_4_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_4_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_5_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_5_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_6_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_6_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_7_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_7_CSE.class);
        startActivity(intent);
    }
    public void GIMT_CSE_8_CSE(View v) {
        Intent intent = new Intent(getApplicationContext(), GIMT_CSE_8_CSE.class);
        startActivity(intent);
    }



















//  MECHANICAL CIE SEMS

    public void JEC_Mecha_1_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_1_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_2_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_2_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_3_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_3_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_4_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_4_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_5_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_5_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_6_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_6_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_7_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_7_CIE.class);
        startActivity(intent);
    }
    public void JEC_Mecha_8_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Mecha_8_CIE.class);
        startActivity(intent);
    }


//  CIVIL CIE SEMS

    public void JEC_Civil_1_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_1_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_2_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_2_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_3_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_3_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_4_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_4_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_5_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_5_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_6_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_6_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_7_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_7_CIE.class);
        startActivity(intent);
    }
    public void JEC_Civil_8_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Civil_8_CIE.class);
        startActivity(intent);
    }


//  CSE CIE's

    public void JEC_CSE_1_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CSE_1_CIE.class);
        startActivity(intent);
    }
    public void JEC_CSE_2_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CSE_2_CIE.class);
        startActivity(intent);
    }
    public void JEC_CSE_3_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CSE_3_CIE.class);
        startActivity(intent);
    }
    public void JEC_CIE_4th_SEM(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CIE_4th_SEM.class);
        startActivity(intent);
    }
    public void JEC_CSE_5_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CSE_5_CIE.class);
        startActivity(intent);
    }
    public void JEC_CIE_6th_SEM(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CIE_6th_SEM.class);
        startActivity(intent);
    }
    public void JEC_CSE_7_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CSE_7_CIE.class);
        startActivity(intent);
    }
    public void JEC_CIE_8th_SEM(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_CIE_8th_SEM.class);
        startActivity(intent);
    }


//  ELECTRICAL CIE SEMS

    public void JEC_Electrical_1_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_1_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_2_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_2_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_3_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_3_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_4_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_4_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_5_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_5_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_6_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_6_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_7_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_7_CIE.class);
        startActivity(intent);
    }
    public void JEC_Electrical_8_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Electrical_8_CIE.class);
        startActivity(intent);
    }


//  INSTRUMENTATION CIE SEMS

    public void JEC_Instru_1_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_1_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_2_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_2_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_3_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_3_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_4_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_4_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_5_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_5_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_6_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_6_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_7_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_7_CIE.class);
        startActivity(intent);
    }
    public void JEC_Instru_8_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), JEC_Instru_8_CIE.class);
        startActivity(intent);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {



            case R.id.livechat:
                Intent livechatIntent = new Intent(getApplicationContext(), livechat.class);
                startActivity(livechatIntent);
                break;



            case R.id.about_us:
                Intent aboutIntent = new Intent(getApplicationContext(), AboutUss.class);
                startActivity(aboutIntent);
                break;


            case R.id.privacy_policy:
                Intent privacyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://btechpaperss.blogspot.com/p/privacy-policy.html"));
                startActivity(privacyIntent);
                break;


            case R.id.razorpay:
                Intent razorpayIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://btechpaperss.blogspot.com/p/razorpay-policy-pages.html"));
                startActivity(razorpayIntent);
                break;



            case R.id.upload_papers:
                Intent upload_papers = new Intent(Intent.ACTION_VIEW, Uri.parse("https://graduationpapers.in/upload-question-papers"));
                startActivity(upload_papers);
                break;




            case R.id.rate_app:

            case R.id.update_the_app:
                Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.application.btechpapers"));
                startActivity(rateIntent);
                break;


            case R.id.contact_us:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:btechpapers777@gmail.com"));
                startActivity(intent);
                break;




            case R.id.share:

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT,"Download Previous Year B.Tech Question Papers");
                share.putExtra(Intent.EXTRA_TEXT,"Download Previous Year B.Tech Question Papers, Get Access to Syllabus, Results, Notifications and Much More. Get Your App Here - https://play.google.com/store/apps/details?id=com.application.btechpapers");
                startActivity(Intent.createChooser(share,"Share With"));


            default:


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInAppUpdateError(int code, Throwable error) {

    }

    @Override
    public void onInAppUpdateStatus(InAppUpdateStatus status) {


        if (status.isDownloaded()) {
            View view = getWindow().getDecorView().findViewById(android.R.id.content);
            Snackbar snackbar = Snackbar.make(view,
                    "An update has been downloaded",
                    Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inAppUpdateManager.completeUpdate();

                }
            });

            snackbar.show();


        }
    }


//ADMOB

    @Override
    protected void onStart() {
        super.onStart();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                AdRequest adRequest = new AdRequest.Builder().build();

                InterstitialAd.load(MainActivity.this,"ca-app-pub-5384391241230668/6241317943", adRequest,
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
                                            case R.id.SyllabusClick:
                                                intent = new Intent(MainActivity.this, syllabus2.class);
                                                break;

                                            case R.id.showInter:
                                                intent = new Intent(MainActivity.this, Premium_Class_Notes.class);
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
}
