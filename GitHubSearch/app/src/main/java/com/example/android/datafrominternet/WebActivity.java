package com.example.android.datafrominternet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_main);

        webView = (WebView)findViewById(R.id.webview);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String urlString = "";
        if(intent.hasExtra("urlString")){
            urlString = intent.getStringExtra("urlString");
            Log.d("mycode", urlString);
        }
        webView.loadUrl(urlString);
    }
}
