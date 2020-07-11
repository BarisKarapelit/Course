package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText txt1,txt2;
    ImageButton Button;
    TextView result;
    String txt1Str,txt2Str,resultStr;
    int txt1Int,txt2Int,resultInt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText)findViewById(R.id.editTextTextPersonName4);
        txt2=(EditText)findViewById(R.id.editTextTextPersonName5);
        Button=(ImageButton) findViewById(R.id.imageButton);
        result=(TextView)findViewById(R.id.textView3);

        Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                txt1Str=txt1.getText().toString();
                txt2Str=txt2.getText().toString();

                txt1Int=Integer.valueOf(txt1Str);
                txt2Int=Integer.parseInt(txt2Str);

                resultInt=txt1Int*txt2Int;
                resultStr=String.valueOf(resultInt);

                result.setText(resultStr);



            }
        });





    }
}