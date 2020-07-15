package com.bariskarapelit.androidservisler;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class TimelineServis extends Service
{
    Timer timer;
    Handler help;
    long  sure=8000;
    Context context;



    @Override
    public void onCreate()
    {
        super.onCreate();
        timer=new Timer();
        help=new Handler(Looper.getMainLooper());
        context =TimelineServis.this;
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                showUyari();
            }
        },0,sure);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    public void showUyari()
    {
        help.post(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(context, "Merhaba Baba ", Toast.LENGTH_SHORT).show();
                Intent dialodIntent = new Intent(context,MainActivity.class);
                dialodIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle b= new Bundle();
                b.putString("mesaj","tugba");
                dialodIntent.putExtras(b);

                startActivity(dialodIntent);
            }
        });
    }

}
