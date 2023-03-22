package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import im.crisp.client.ChatActivity;
import im.crisp.client.Crisp;

public class livechat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livechat);

        Crisp.configure(getApplicationContext(), "02ad1c70-12fc-4241-a804-614d8c147272");
        Intent crispIntent = new Intent(this, ChatActivity.class);
        startActivity(crispIntent);
    }
}