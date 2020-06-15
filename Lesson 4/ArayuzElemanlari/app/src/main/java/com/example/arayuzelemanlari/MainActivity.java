package com.example.arayuzelemanlari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String position,position1,positionTotal ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_uyari=(Button)findViewById(R.id.Btn);
        CheckBox checkBox_tur=(CheckBox)findViewById(R.id.checkbox_tur);
        CheckBox checkBox_eng=(CheckBox)findViewById(R.id.checkbox_eng);
        RadioButton rMan=(RadioButton)findViewById(R.id.man);
        RadioButton rWoman=(RadioButton)findViewById(R.id.woman);
        ImageButton ımageBtn =(ImageButton)findViewById(R.id.imageButton);
        boolean tur_case=checkBox_tur.isEnabled();
        boolean eng_case=checkBox_eng.isEnabled();





        rMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Click Man", Toast.LENGTH_LONG).show();
            }
        });

        if (tur_case==true)
        {
            position1="turkish selected and turkish selected";
            /*if(eng_case==true)
            {
                position1="English selected and turkish selected";
                System.out.println("girdim");
            }else if(eng_case==false)
            {
                position1="English does not selected and Turkish selected";
            }*/


        }

        /*else if(tur_case==false)
        {

            if(eng_case==true)
            {
                position1="English selected and turkish does not selected";
            }else if(eng_case==false)
            {
                position1="English does not selected and Turkish does not selected";
            }

        }*/

        btn_uyari.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,position1,Toast.LENGTH_LONG).show();
            }
        });
    }
}