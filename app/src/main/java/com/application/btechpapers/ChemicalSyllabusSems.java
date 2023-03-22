package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChemicalSyllabusSems extends AppCompatActivity {


    public void Chemical1SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical1SyllabusWV.class);
        startActivity(intent);
    }

    public void Chemical2SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical2SyllabusWV.class);
        startActivity(intent);
    }

    public void Chemical3SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical3SyllabusWV.class);
        startActivity(intent);
    }

    public void Chemical4SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical4SyllabusWV.class);
        startActivity(intent);
    }

    public void Chemical5SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical5SyllabusWV.class);
        startActivity(intent);
    }

    public void Chemical6SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical6SyllabusWV.class);
        startActivity(intent);
    }
    public void Chemical7SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical7SyllabusWV.class);
        startActivity(intent);
    }
    public void Chemical8SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Chemical8SyllabusWV.class);
        startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_syllabus_sems);
    }
}