package com.bariskarapelit.soap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;

public class Permssion extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permssion);
        final Button checkPermission=(Button)findViewById(R.id.button2);
        Button requestPermissionBtn= (Button)findViewById(R.id.button3);
        checkPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               if (checkPermission())
               {
                   Toast.makeText(Permssion.this,"Permission already granted",Toast.LENGTH_LONG).show();

               }
               else
               {
                   Toast.makeText(Permssion.this,"Please request permission",Toast.LENGTH_LONG).show();
               }
            }
        });
        requestPermissionBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (checkPermission())
                {
                    requestPermission();
                }
                else
                {
                    Toast.makeText(Permssion.this,"Permission already granted",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public  boolean checkPermission()
    {
        int result=ContextCompat.checkSelfPermission(getApplicationContext(),ACCESS_FINE_LOCATION);
        int result2=ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA);

        return result == PackageManager.PERMISSION_GRANTED && result2==PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 200:
                if (grantResults.length > 0) {
                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (locationAccepted && cameraAccepted) {
                        Toast.makeText(Permssion.this,
                                "Now you can accepted local data and camera", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Permssion.this,
                                "Permission don't", Toast.LENGTH_LONG).show();
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        if(shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION))
                        {
                            requestPermissions(new String[]{CAMERA,ACCESS_FINE_LOCATION},200);
                        }
                    }

                    break;
                }
        }
    }
    public void requestPermission()
    {
        ActivityCompat.requestPermissions(this,new String[]{CAMERA,ACCESS_FINE_LOCATION},200);

    }

}