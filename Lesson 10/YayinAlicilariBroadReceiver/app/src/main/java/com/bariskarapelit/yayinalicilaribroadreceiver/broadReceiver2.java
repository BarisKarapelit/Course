package com.bariskarapelit.yayinalicilaribroadreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class broadReceiver2 extends AppCompatActivity
{
    SeekBar levelBar;
    TextView textView;
    BroadcastReceiver broadcastReceiver= new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            int Seviye =intent.getIntExtra("level",-1);
            levelBar.setMax(100);
            levelBar.setProgress(Seviye);
            textView.setText("Batarya Seviyesi: "+Seviye);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_receiver2);

        levelBar =findViewById(R.id.seekBar);
        textView=findViewById(R.id.level);

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver,intentFilter);



    }
}