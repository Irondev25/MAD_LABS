package com.irondev25.lab3a;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BrowserActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        webView = (WebView) findViewById(R.id.wv);
        webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl("https://www.google.com");
    }
}
