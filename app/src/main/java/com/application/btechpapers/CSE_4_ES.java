package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CSE_4_ES extends AppCompatActivity {

    private WebView webView;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewcontainer);

        webView = (WebView) findViewById(R.id.webviewcontain);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.loadUrl("https://drive.google.com/drive/folders/1U_7Ldg7sXtq8NtCQxSdBvLegQGOUDKT8?usp=sharing");
    }
}