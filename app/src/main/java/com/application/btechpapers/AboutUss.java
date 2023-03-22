package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUss extends AppCompatActivity {


    ImageView facebook;
    ImageView linkedin;
    ImageView github;
    ImageView whatsapp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_uss);
        getSupportActionBar().hide();



        facebook = findViewById(R.id.facebook);
        linkedin = findViewById(R.id.linkedin);
        github = findViewById(R.id.github);
        whatsapp = findViewById(R.id.whatsapp);


        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               String sNumber = "+917670035943";
               Uri uri =Uri.parse(String.format(
                       "https://api.whatsapp.com/send?phone=%s",sNumber
               ));
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(uri);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
            }
        });






        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://facebook.com/itssubhamroy");
            }
        });






        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/itssubhamroy");
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://github.com/itssubhamroy23");
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    }
