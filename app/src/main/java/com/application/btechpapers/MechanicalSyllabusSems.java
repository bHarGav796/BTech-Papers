package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MechanicalSyllabusSems extends AppCompatActivity {

    public void Mecha1SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha1SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha2SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha2SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha3SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha3SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha4SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha4SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha5SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha5SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha6SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha6SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha7SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha7SyllabusWV.class);
        startActivity(intent);
    }

    public void Mecha8SyllabusWV(View v) {
        Intent intent = new Intent(getApplicationContext(), Mecha8SyllabusWV.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mechanical_syllabus_sems);
    }
}