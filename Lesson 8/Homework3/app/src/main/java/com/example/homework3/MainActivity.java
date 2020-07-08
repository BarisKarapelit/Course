package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    Button buttonCreate;
    EditText editTextName,editTextSurname;
    String userIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        buttonCreate=(Button)findViewById(R.id.buttonCreate);
        editTextName =(EditText)findViewById(R.id.editTextTextName);
        editTextSurname=(EditText)findViewById(R.id.editTextSurname);
        buttonCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nameStr=editTextName.getText().toString();
                String surnameStr=editTextSurname.getText().toString();
                userIntro=nameStr +" "+ surnameStr;

                Intent intent = new Intent(MainActivity.this,AccountList.class);
                //Editbox değerlerinhangi sayfaya gidecek belirledik

                Bundle bundle = new Bundle();
                bundle.putString("user",userIntro);

                //String değerleri bundle içine atık


                intent.putExtras(bundle);

                startActivity(intent);


                Toast.makeText(MainActivity.this,"Accept",Toast.LENGTH_LONG).show();

            }
        });

    }
}