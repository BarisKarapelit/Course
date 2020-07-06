package com.example.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button detailGo=(Button)findViewById(R.id.button);
        name =(EditText)findViewById(R.id.editTextTextPersonName);

        detailGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue=name.getText().toString();
                Intent intent =new Intent(MainActivity.this,ProfilDetail.class);
                Bundle b=new Bundle();
                b.putString("İSİM",nameValue);
                intent.putExtras(b);
                startActivity(intent);
            }
        });


    }
}