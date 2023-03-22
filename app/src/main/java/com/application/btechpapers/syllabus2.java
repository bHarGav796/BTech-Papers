package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class syllabus2 extends AppCompatActivity {


    private final static String TAG = "Admob";
    Button Civil2ndSem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus2);


    }




    public void syllabusCivilEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), CivilSyllabusSems.class);
        startActivity(intent);
    }



    public void syllabusMechanicalEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), MechanicalSyllabusSems.class);
        startActivity(intent);
    }


    public void syllabusElectricalEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), ElectricalSyllabusSems.class);
        startActivity(intent);
    }

    public void syllabusCSEEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), CSESyllabusSems.class);
        startActivity(intent);
    }

    public void syllabusETCEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), ECESyllabusSems.class);
        startActivity(intent);
    }

    public void syllabusChemicalEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), ChemicalSyllabusSems.class);
        startActivity(intent);
    }

    public void syllabusInstrumentationEngg(View v) {
        Intent intent = new Intent(getApplicationContext(), InstruSyllabusSems.class);
        startActivity(intent);
    }

















}