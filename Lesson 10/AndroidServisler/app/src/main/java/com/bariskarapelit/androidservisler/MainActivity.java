package com.bariskarapelit.androidservisler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button starBtn =findViewById(R.id.buttonSrt);
        Button stopBtn = findViewById(R.id.buttonStop);

        WebView chrome = findViewById(R.id.webView);
        chrome.getSettings().setJavaScriptEnabled(true);
        chrome.loadUrl("https://bariskarapelit.com/");



        /*

        starBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startService(new Intent(MainActivity.this,TimelineServis.class));
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                stopService(new Intent(MainActivity.this,TimelineServis.class));


            }
        });


        Bundle extras = getIntent().getExtras();
        String msj;
        if (extras!=null)
        {
            msj=extras.getString("mesaj");
            Log.w("deger",msj);
        }

         */
    }


}