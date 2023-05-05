package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Internal_BBEC_Branches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internal_bbec_branches);
    }

//    BBEC Departments
    public void BBEC_Internal_ELectrical_Sems(View v) {
        Intent intent = new Intent(getApplicationContext(), BBEC_Internal_ELectrical_Sems.class);
        startActivity(intent);
    }


}