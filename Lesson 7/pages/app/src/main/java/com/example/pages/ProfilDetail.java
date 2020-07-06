package com.example.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        TextView txt =(TextView)findViewById(R.id.textView);


        Bundle extras=getIntent().getExtras();
        String name="";
        if(extras!=null)
        {
           name= extras.getString("İSİM");
        }
        txt.setText(name);
        Toast.makeText(this,"Welcome to "+name,Toast.LENGTH_LONG).show();
    }
}