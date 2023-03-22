package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ECESyllabusSems extends AppCompatActivity {


    public void ETC1SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC1SyllabusWV.class);
        startActivity(intent);
    }


    public void ETC2SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC2SyllabusWV.class);
        startActivity(intent);
    }


    public void ETC3SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC3SyllabusWV.class);
        startActivity(intent);
    }


    public void ETC4SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC4SyllabusWV.class);
        startActivity(intent);
    }


    public void ETC5SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC5SyllabusWV.class);
        startActivity(intent);
    }


    public void ETC6SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC6SyllabusWV.class);
        startActivity(intent);
    }


    public void ETC7SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC7SyllabusWV.class);
        startActivity(intent);
    }

    public void ETC8SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), ETC8SyllabusWV.class);
        startActivity(intent);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecesyllabus_sems);
    }
}