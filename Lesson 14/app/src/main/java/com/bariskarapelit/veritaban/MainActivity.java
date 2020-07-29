package com.bariskarapelit.veritaban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Database database;
    EditText subetxt,ipadres;
    Button addbtn,listbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database= new Database(MainActivity.this);
        subetxt=findViewById(R.id.sube);
        addbtn=findViewById(R.id.insertBtn);
        ipadres=findViewById(R.id.ip);
        listbtn=findViewById(R.id.button);



        addbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String subeTxtStr= subetxt.getText().toString();
                String ipTxtStr= ipadres.getText().toString();
                long errorStatus=database.insertIpadres(ipTxtStr,subeTxtStr);
                if (errorStatus==-1)
                {
                    Log.w("insert","insert yapılamadı");
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Yapıldı",Toast.LENGTH_LONG).show();
                }

            }
        });
        listbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent= new Intent(MainActivity.this,DetayActivity.class);
                startActivity(intent);
            }
        });
    }
}