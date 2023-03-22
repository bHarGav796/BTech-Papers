package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CSESyllabusSems extends AppCompatActivity {

    public void CSE1SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE1SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE2SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE2SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE3SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE3SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE4SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE4SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE5SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE5SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE6SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE6SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE7SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE7SyllabusWV.class);
        startActivity(intent);
    }

    public void CSE8SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), CSE8SyllabusWV.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.csesyllabus_sems);
    }
}