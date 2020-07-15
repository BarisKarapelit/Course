package com.bariskarapelit.yayinalicilaribroadreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button email=findViewById(R.id.button);
       /* TextView txt =findViewById(R.id.textView);
        txt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri callNumber =Uri.parse("tel:5334357218");
                Intent intentCall = new Intent(Intent.ACTION_DIAL,callNumber);
                startActivity(intentCall);

            }
        });*/


       Intent intent = new Intent(MainActivity.this,AirplayMod.class);
       startActivity(intent);

        email.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                /*Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                String[] adresler= {"tugba.ust2008@gmail.com","info@smality.com","bkarapelit48@gmail.com"};
                emailIntent.putExtra(Intent.EXTRA_EMAIL,adresler);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Welcome to Cehenme");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"Bu sene mezun olabilecen mi?");


                Intent chooseEmailApp = Intent.createChooser(emailIntent,"Uygulama Bellirlenmesi");
               // startActivity(chooseEmailApp);

                Uri webPage= Uri.parse("https://www.bariskarapelit.com");
                Intent intentWeb= new Intent(Intent.ACTION_VIEW,webPage);
                startActivity(intentWeb);*/




            }
        });
    }


}