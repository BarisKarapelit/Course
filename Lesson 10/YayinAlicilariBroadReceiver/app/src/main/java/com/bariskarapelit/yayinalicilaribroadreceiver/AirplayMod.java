package com.bariskarapelit.yayinalicilaribroadreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class AirplayMod extends AppCompatActivity
{
    BroadcastReceiver airplayBroadcastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            Toast.makeText(context,"Ucuyoruz Babaaaaa...",Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airplay);

        IntentFilter IntentAirplay= new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplayBroadcastReceiver,IntentAirplay);

    }
}