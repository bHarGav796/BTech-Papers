package com.application.btechpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CSE_2_Chem extends AppCompatActivity {

    private WebView webView;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewcontainer);

        webView = (WebView) findViewById(R.id.webviewcontain);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.loadUrl("https://drive.google.com/drive/folders/1uMc0LdmHJC1NRpRgTFBbOTy_sLz1TVhN?usp=sharing");
    }
}