package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Internal_Golaghat_Engineering_College extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_golaghat_engineering_college);

    }
    //    Golaghat Engineering College 4 Departments

    public void Internal_Golaghat_Mechanical_Sems_OnClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Internal_GEC_Mechanical_Sems.class);
        startActivity(intent);
    }

    public void GEC_Civil_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), Internal_GEC_Civil_Sems.class);
        startActivity(intent);
    }

    public void GEC_CSE_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), Internal_GEC_CSE_Sems.class);
        startActivity(intent);
    }

    public void GEC_Chemical_CIE(View v) {
        Intent intent = new Intent(getApplicationContext(), Internal_GEC_Chemical_Sems.class);
        startActivity(intent);
    }

    // Golaghat Engineering College Mechanical Engineering All Semesters



}